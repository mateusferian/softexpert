package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.DiscountEntity;
import br.com.mateusferian.softexpert.repositories.EndUserValueRepository;
import br.com.mateusferian.softexpert.services.EndUserValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EndUserValueServiceImpl implements EndUserValueService {

    @Autowired
    public EndUserValueRepository endUserValueRepository;

    @Override
    public Iterable<DiscountEntity> findAll() {
        return endUserValueRepository.findAll();
    }

    @Override
    public DiscountEntity save(DiscountEntity entity) {
        return endUserValueRepository.save(entity);
    }
}
