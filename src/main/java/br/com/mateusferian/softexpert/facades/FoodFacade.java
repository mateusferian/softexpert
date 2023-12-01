package br.com.mateusferian.softexpert.facades;

import br.com.mateusferian.softexpert.dtos.requests.FoodRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.FoodResponseDTO;

import java.util.List;

public interface FoodFacade {

    List<FoodResponseDTO> findAll();

    FoodResponseDTO save(FoodRequestDTO request);
}
