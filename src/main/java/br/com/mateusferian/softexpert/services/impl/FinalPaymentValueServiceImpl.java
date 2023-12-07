package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.FinalPaymentValueEntity;
import br.com.mateusferian.softexpert.repositories.FinalPaymentValueRepository;
import br.com.mateusferian.softexpert.services.FinalPaymentValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FinalPaymentValueServiceImpl implements FinalPaymentValueService {

    @Autowired
    public FinalPaymentValueRepository finalPaymentValueRepository;

    @Override
    public Iterable<FinalPaymentValueEntity> findAll() {
        log.info("listing final payment value");
        return finalPaymentValueRepository.findAll();
    }

    @Override
    public FinalPaymentValueEntity save(FinalPaymentValueEntity entity) {
        log.info("registering a new final payment value");
        return finalPaymentValueRepository.save(entity);
    }
}
