package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.repositories.PurchaseRepository;
import br.com.mateusferian.softexpert.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public Iterable<PurchaseEntity> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public PurchaseEntity save(PurchaseEntity entity) {
        return purchaseRepository.save(entity);
    }
}
