package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.repositories.OrderRepository;
import br.com.mateusferian.softexpert.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Iterable<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity save(OrderEntity entity) {
        return orderRepository.save(entity);
    }
}
