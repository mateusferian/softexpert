package br.com.mateusferian.softexpert.facades.impl;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;
import br.com.mateusferian.softexpert.facades.PurchaseFacade;
import br.com.mateusferian.softexpert.mappers.PurchaseMapper;
import br.com.mateusferian.softexpert.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PurchaseFacadeImpl implements PurchaseFacade {

    @Autowired
    private PurchaseMapper mapper;

    @Autowired
    private PurchaseService purchaseService;

    private static final double DELIVERY_VALUE  = 8;
    @Override
    public List<PurchaseResponseDTO> findAll() {
        return mapper.toDtoList(purchaseService.findAll());
    }

    @Override
    public PurchaseResponseDTO save(PurchaseRequestDTO request) {
        return mapper.toDto(purchaseService.save(mapper.toEntity(request)));
    }


    private BigDecimal deliveryValidation(DeliveryTypeEnum deliveryTypeEnum){
         BigDecimal deliveryFee = BigDecimal.valueOf(0);

        if(deliveryTypeEnum.equals("WITH_DELIVERY")){
            deliveryFee = BigDecimal.valueOf(DELIVERY_VALUE).add(deliveryFee);
    }else{
            deliveryFee = BigDecimal.valueOf(0);
        }

        return deliveryFee;
    }
}
