package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.repositories.FoodRepository;
import br.com.mateusferian.softexpert.services.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FoodServiceImpl implements FoodService {

    @Autowired
    public FoodRepository foodRepository;

    @Override
    public Iterable<FoodEntity> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public FoodEntity save(FoodEntity entity) {
        return foodRepository.save(entity);
    }
}
