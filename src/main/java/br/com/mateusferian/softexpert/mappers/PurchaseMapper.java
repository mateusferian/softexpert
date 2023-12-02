package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;
import br.com.mateusferian.softexpert.repositories.FoodRepository;
import br.com.mateusferian.softexpert.repositories.OrderRepository;
import br.com.mateusferian.softexpert.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class PurchaseMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrderRepository orderRepository;

    public PurchaseResponseDTO toDto(PurchaseEntity entity) {
        return mapper.map(entity, PurchaseResponseDTO.class);
    }

    public PurchaseEntity toEntity(PurchaseRequestDTO request){

        PurchaseEntity purchase = mapper.map(request, PurchaseEntity.class);

        OrderEntity order = (orderRepository.findById(request.getOrder()).orElse(new OrderEntity()));

        purchase.setRequestDate(new Date());


        BigDecimal valueTotalFoods = calculateTotalFoodCosts(order.getFood());
        purchase.setOrder(order);
        purchase.setTotalValue(calculateTotal(valueTotalFoods, request.getDelivery() , request.getDiscount()));

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

    private BigDecimal calculateTotalOrders(List<FoodEntity> foods) {
        BigDecimal valueFoods = BigDecimal.ZERO;
        for (FoodEntity food : foods) {
            valueFoods = valueFoods.add(food.getValue());
        }
        return valueFoods;
    }

    private BigDecimal calculateTotal(BigDecimal order, BigDecimal delivery, BigDecimal discount) {

        order = (order == null) ? BigDecimal.ZERO : order;
        delivery = (delivery == null) ? BigDecimal.ZERO : delivery;
        discount = (discount == null) ? BigDecimal.ZERO : discount;

        BigDecimal totalValue = order.add(delivery).subtract(discount);

        return totalValue;
    }
}
