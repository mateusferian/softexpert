package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.FinalPaymentValueEntity;
import br.com.mateusferian.softexpert.repositories.DiscountRepository;
import br.com.mateusferian.softexpert.services.DiscountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    public DiscountRepository discountRepository;

    @Override
    public Iterable<FinalPaymentValueEntity> findAll() {
        log.info("listing discounts");
        return discountRepository.findAll();
    }

    @Override
    public FinalPaymentValueEntity save(FinalPaymentValueEntity entity) {
        log.info("registering a new discount");
        return discountRepository.save(entity);
    }
}
