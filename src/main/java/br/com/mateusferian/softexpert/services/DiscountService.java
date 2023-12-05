package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.DiscountEntity;

public interface DiscountService {

    Iterable<DiscountEntity> findAll();

    DiscountEntity save(DiscountEntity entity);
}
