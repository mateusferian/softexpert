package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.repositories.OrderRepository;
import br.com.mateusferian.softexpert.utils.FoodCalculatorUtil;
import br.com.mateusferian.softexpert.utils.OrderCalculatorUtil;
import br.com.mateusferian.softexpert.utils.TotalCalculatorUtil;
import br.com.mateusferian.softexpert.utils.ValueGeneratorUtil;
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

    @Autowired
    private FoodCalculatorUtil foodCalculatorUtil;

    @Autowired
    private OrderCalculatorUtil orderCalculatorUtil;

    @Autowired
    private ValueGeneratorUtil valueGeneratorUtil;

    @Autowired
    private TotalCalculatorUtil totalCalculatorUtil;

    public PurchaseResponseDTO toDto(PurchaseEntity entity) {
        log.info("converting entity{} to dto", entity);
        return mapper.map(entity, PurchaseResponseDTO.class);
    }

    public PurchaseEntity toEntity(PurchaseRequestDTO request){
        log.info("converting dto{} to entity", request);
        PurchaseEntity purchase = mapper.map(request, PurchaseEntity.class);
        List<Long> ordersId  = request.getOrder();
        List<OrderEntity> orders = (List<OrderEntity>) orderRepository.findAllById(ordersId);

        purchase.setOrder(orders);
        purchase.setPurchaseDate(new Date());
        purchase.setFinalPaymentValue(valueGeneratorUtil.finalValueGenerator(orders, request.getDiscount(), request.getDelivery()));

        BigDecimal valueTotalOrders = orderCalculatorUtil.calculateTotalOrders(orders);
        purchase.setTotalValue(totalCalculatorUtil.calculateTotal(valueTotalOrders, request.getDelivery() , request.getDiscount()));

        return purchase;
    }

    public List<PurchaseResponseDTO> toDtoList(Iterable<PurchaseEntity> list){
        log.info("converting entity list{} to dto list", list);
        List<PurchaseEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
