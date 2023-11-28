package br.com.mateusferian.softexpert.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private String nameOrder;

    private BigDecimal value;

    private Long purchase;
}
