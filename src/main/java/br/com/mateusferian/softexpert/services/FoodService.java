package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.FoodEntity;

public interface FoodService {

    Iterable<FoodEntity> findAll();

    FoodEntity save(FoodEntity entity);
}
