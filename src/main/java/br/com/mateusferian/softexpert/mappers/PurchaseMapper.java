package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.exceptions.OrderException;
import br.com.mateusferian.softexpert.exceptions.enums.OrderEnum;
import br.com.mateusferian.softexpert.services.OrderService;
import br.com.mateusferian.softexpert.utils.CalculatorUtil;
import br.com.mateusferian.softexpert.utils.CheckUtil;
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
    private OrderService orderService;

    @Autowired
    private ValueGeneratorUtil valueGeneratorUtil;

    @Autowired
    private CalculatorUtil calculatorUtil;

    @Autowired
    private CheckUtil checkUtil;

    public PurchaseResponseDTO toDto(PurchaseEntity entity) {
        log.info("converting entity{} to dto", entity);
        return mapper.map(entity, PurchaseResponseDTO.class);
    }

    public PurchaseEntity toEntity(PurchaseRequestDTO request){
        log.info("converting dto{} to entity", request);
        PurchaseEntity purchase = mapper.map(request, PurchaseEntity.class);
        List<Long> ordersId  = request.getOrder();
        List<OrderEntity> orders = (List<OrderEntity>) orderService.findAllById(ordersId);

        List<Long> foundIds = orders.stream().map(OrderEntity::getId).collect(Collectors.toList());
        List<Long> notFoundIds = ordersId.stream().filter(id -> !foundIds.contains(id)).collect(Collectors.toList());

        if(!notFoundIds.isEmpty()) {
            throw new OrderException(OrderEnum.SOME_OF_ORDERS_NOT_FOUND);
        }

        purchase.setOrder(orders);
        purchase.setPurchaseDate(new Date());

        BigDecimal valueTotalOrders = calculatorUtil.calculateTotalOrders(orders);
        BigDecimal valueOfTheIncrease = checkUtil.operationTypeCheck(request.getOperationType(), request.getAdditionalOperational(),valueTotalOrders);

        purchase.setFinalPaymentValue(valueGeneratorUtil.finalValueGenerator(orders, request.getDiscount(), valueOfTheIncrease));
        purchase.setTotalValue(calculatorUtil.calculatingTotalPurchase(valueTotalOrders, valueOfTheIncrease, request.getDiscount()));
        
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

