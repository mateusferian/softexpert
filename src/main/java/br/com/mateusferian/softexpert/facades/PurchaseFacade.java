package br.com.mateusferian.softexpert.facades;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;

import java.util.List;

public interface PurchaseFacade {

    List<PurchaseResponseDTO> findAll();
    PurchaseResponseDTO save(PurchaseRequestDTO request);
}
