package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.repositories.PurchaseRepository;
import br.com.mateusferian.softexpert.services.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public Iterable<PurchaseEntity> findAll() {
        log.info("listing purchases");
        return purchaseRepository.findAll();
    }

    @Override
    public PurchaseEntity save(PurchaseEntity entity) {
        log.info("registering a new purchase");
        return purchaseRepository.save(entity);
    }
}
