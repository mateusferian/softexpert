package br.com.mateusferian.softexpert.controllers;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.facades.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/softexpert/order")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    @GetMapping
    public List<OrderResponseDTO> findAll(){
        return orderFacade.findAll();
    }

    @PostMapping
    public OrderResponseDTO save(@RequestBody OrderRequestDTO request){
        return orderFacade.save(request);
    }
}
