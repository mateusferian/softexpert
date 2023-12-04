package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.DiscountEntity;

public interface EndUserValueService {

    Iterable<DiscountEntity> findAll();

    DiscountEntity save(DiscountEntity entity);
}
