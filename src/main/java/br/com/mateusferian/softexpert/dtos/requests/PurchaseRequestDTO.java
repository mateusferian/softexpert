package br.com.mateusferian.softexpert.dtos.requests;

import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDTO {

    private String nameUser;

    private DeliveryTypeEnum deliveryType;

    private BigDecimal discount;
}
