package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.repositories.FoodRepository;
import br.com.mateusferian.softexpert.services.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FoodServiceImpl implements FoodService {

    @Autowired
    public FoodRepository foodRepository;

    @Override
    public Iterable<FoodEntity> findAll() {
        log.info("listing foods");
        return foodRepository.findAll();
    }

    @Override
    public FoodEntity save(FoodEntity entity) {
        log.info("registering a new food");
        return foodRepository.save(entity);
    }

    @Override
    public Iterable<FoodEntity> findAllById(List<Long> foodsId) {
        log.info("obtaining information from an foods list {}", foodsId);
        return foodRepository.findAllById(foodsId);
    }
}
