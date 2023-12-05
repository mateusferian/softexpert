package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.FinalPaymentValueEntity;

public interface FinalPaymentValueService {

    Iterable<FinalPaymentValueEntity> findAll();

    FinalPaymentValueEntity save(FinalPaymentValueEntity entity);
}
