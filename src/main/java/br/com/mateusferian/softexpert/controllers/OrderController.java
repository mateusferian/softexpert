package br.com.mateusferian.softexpert.controllers;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.facades.OrderFacade;
import br.com.mateusferian.softexpert.facades.PurchaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public OrderResponseDTO save(@Valid  @RequestBody OrderRequestDTO request){
        return orderFacade.save(request);
    }
}
