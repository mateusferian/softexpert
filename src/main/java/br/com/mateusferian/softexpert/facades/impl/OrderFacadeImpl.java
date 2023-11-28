package br.com.mateusferian.softexpert.facades.impl;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.facades.OrderFacade;
import br.com.mateusferian.softexpert.mappers.OrderMapper;
import br.com.mateusferian.softexpert.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private OrderService orderService;

    private static final double DELIVERY_VALUE  = 8;
    @Override
    public List<OrderResponseDTO> findAll() {
        return mapper.toDtoList(orderService.findAll());
    }

    @Override
    public OrderResponseDTO save(OrderRequestDTO request) {
        return mapper.toDto(orderService.save(mapper.toEntity(request)));
    }


}
