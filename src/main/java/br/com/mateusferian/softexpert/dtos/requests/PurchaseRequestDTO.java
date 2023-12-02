package br.com.mateusferian.softexpert.dtos.requests;

import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDTO {

    private Long order;

    private BigDecimal discount;

    private BigDecimal delivery;
}

