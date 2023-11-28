package br.com.mateusferian.softexpert.dtos.response;

import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDTO {

    private Long id;

    private String nameUser;

    private DeliveryTypeEnum deliveryType;

    private BigDecimal discount;

    private BigDecimal totalPayable;
}
