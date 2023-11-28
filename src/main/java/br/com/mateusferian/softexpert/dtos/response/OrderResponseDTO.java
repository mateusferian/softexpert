package br.com.mateusferian.softexpert.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Long id;

    private String nameOrder;

    private BigDecimal value;

    private PurchaseResponseDTO purchase;
}