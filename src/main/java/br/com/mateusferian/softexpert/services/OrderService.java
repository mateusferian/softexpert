package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.OrderEntity;

public interface OrderService {

    Iterable<OrderEntity> findAll();

    OrderEntity save(OrderEntity entity);
}
