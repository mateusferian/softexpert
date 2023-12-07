package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.UserEntity;
import br.com.mateusferian.softexpert.exceptions.UserException;
import br.com.mateusferian.softexpert.exceptions.enums.UserEnum;
import br.com.mateusferian.softexpert.repositories.OrderRepository;
import br.com.mateusferian.softexpert.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Iterable<OrderEntity> findAll() {
        log.info("listing orders");
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity save(OrderEntity entity) {
        log.info("registering a new order");
        return orderRepository.save(entity);
    }

    @Override
    public Iterable<OrderEntity> findAllById( List<Long> ordersId) {
        log.info("obtaining information from an order list {}", ordersId);
        return orderRepository.findAllById(ordersId);
    }
}
