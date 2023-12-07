package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.UserEntity;

import java.util.List;

public interface FoodService {

    Iterable<FoodEntity> findAll();

    FoodEntity save(FoodEntity entity);

    Iterable<FoodEntity> findAllById(List<Long> foodsId);
}
