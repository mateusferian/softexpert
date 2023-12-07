package br.com.mateusferian.softexpert.controllers;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.facades.PurchaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/softexpert/pucharse")
public class PurchaseController {

    @Autowired
    private PurchaseFacade purchaseFacade;

    @GetMapping
    public List<PurchaseResponseDTO> findAll(){
        return purchaseFacade.findAll();
    }

    @PostMapping
    public PurchaseResponseDTO save(@Valid  @RequestBody PurchaseRequestDTO request){
        return purchaseFacade.save(request);
    }
}
