package br.com.mateusferian.softexpert.controllers;

import br.com.mateusferian.softexpert.dtos.requests.FoodRequestDTO;
import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.FoodResponseDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.facades.FoodFacade;
import br.com.mateusferian.softexpert.facades.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/softexpert/food")
public class FoodController {

    @Autowired
    private FoodFacade foodFacade;

    @GetMapping
    public List<FoodResponseDTO> findAll(){
        return foodFacade.findAll();
    }

    @PostMapping
    public FoodResponseDTO save(@Valid @RequestBody FoodRequestDTO request){
        return foodFacade.save(request);
    }
}
