package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.OrderEntity;

import java.util.List;

public interface OrderService {

    Iterable<OrderEntity> findAll();

    OrderEntity save(OrderEntity entity);

    Iterable<OrderEntity> findAllById( List<Long> ordersId);
}
