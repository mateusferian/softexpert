package br.com.mateusferian.softexpert.facades.impl;

import br.com.mateusferian.softexpert.dtos.requests.FoodRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.FoodResponseDTO;
import br.com.mateusferian.softexpert.facades.FoodFacade;
import br.com.mateusferian.softexpert.mappers.FoodMapper;
import br.com.mateusferian.softexpert.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodFacadeImpl implements FoodFacade {

    @Autowired
    private FoodMapper mapper;

    @Autowired
    private FoodService foodService;

    @Override
    public List<FoodResponseDTO> findAll() {
        return mapper.toDtoList(foodService.findAll());
    }

    @Override
    public FoodResponseDTO save(FoodRequestDTO request) {
        return mapper.toDto(foodService.save(mapper.toEntity(request)));
    }
}
