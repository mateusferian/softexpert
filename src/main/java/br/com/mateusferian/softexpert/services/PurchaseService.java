package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;

import java.util.List;

public interface PurchaseService {

    Iterable<PurchaseEntity> findAll();

    PurchaseEntity save(PurchaseEntity entity);
}
