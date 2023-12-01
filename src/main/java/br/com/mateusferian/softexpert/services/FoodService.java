package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.UserEntity;

public interface FoodService {

    Iterable<FoodEntity> findAll();

    FoodEntity save(FoodEntity entity);
}
