package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.entities.DiscountEntity;
import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.repositories.OrderRepository;
import br.com.mateusferian.softexpert.services.EndUserValueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class PurchaseMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EndUserValueService endUserValueService;

    public PurchaseResponseDTO toDto(PurchaseEntity entity) {
        return mapper.map(entity, PurchaseResponseDTO.class);
    }

    public PurchaseEntity toEntity(PurchaseRequestDTO request){

        PurchaseEntity purchase = mapper.map(request, PurchaseEntity.class);
        List<Long> ordersId  = request.getOrder();

        List<OrderEntity> orders = (List<OrderEntity>) orderRepository.findAllById(ordersId);
        purchase.setOrder(orders);
        purchase.setRequestDate(new Date());
        purchase.setDiscountList(updateOrderInfo(orders));
        BigDecimal valueTotalOrders = calculateTotalOrders(orders);
        purchase.setTotalValue(calculateTotal(valueTotalOrders, request.getDelivery() , request.getDiscount()));

        return purchase;
    }

    public List<PurchaseResponseDTO> toDtoList(Iterable<PurchaseEntity> list){
        List<PurchaseEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private BigDecimal calculateTotalFoodCosts(List<FoodEntity> foods) {
        BigDecimal valueFoods = BigDecimal.ZERO;
        for (FoodEntity food : foods) {
            valueFoods = valueFoods.add(food.getValue());
        }
        return valueFoods;
    }

    private BigDecimal calculateTotalOrders(List<OrderEntity> orders) {
        BigDecimal valueOrders = BigDecimal.ZERO;
        for (OrderEntity order : orders) {
            valueOrders = valueOrders.add(calculateTotalFoodCosts(order.getFood()));
        }
        return valueOrders;
    }

    private BigDecimal calculateTotal(BigDecimal order, BigDecimal delivery, BigDecimal discount) {

        order = (order == null) ? BigDecimal.ZERO : order;
        delivery = (delivery == null) ? BigDecimal.ZERO : delivery;
        discount = (discount == null) ? BigDecimal.ZERO : discount;

        BigDecimal totalValue = order.add(delivery).subtract(discount);

        return totalValue;
    }

//    public List<Map<String, Object>> updateOrderInfo(List<OrderEntity> orders) {
//        List<Map<String, Object>> listOfFinalValues = new ArrayList<>();
//
//        for (OrderEntity order : orders) {
//            BigDecimal foodCost = calculateTotalFoodCosts(order.getFood());
//
//            Map<String, Object> orderInfoMap = new HashMap<>();
//            orderInfoMap.put("userName", order.getUser().getName());
//            orderInfoMap.put("foodCost", foodCost);
//
//            listOfFinalValues.add(orderInfoMap);
//        }
//
//        return listOfFinalValues;
//    }

    public List<DiscountEntity> updateOrderInfo(List<OrderEntity> orders) {
        List<DiscountEntity> listEndUserValue = new ArrayList<>();

        for (OrderEntity order : orders) {
            // Para cada pedido, criamos uma nova instância de EndUserValueEntity
            DiscountEntity endUserValue = new DiscountEntity();

            BigDecimal foodCost = calculateTotalFoodCosts(order.getFood());
            endUserValue.setName(order.getUser().getName());
            endUserValue.setValue(foodCost);

            // Salvamos a instância de EndUserValueEntity
            listEndUserValue.add(endUserValueService.save(endUserValue));
        }

        return listEndUserValue;
    }

}
