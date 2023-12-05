package br.com.mateusferian.softexpert.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDTO {

    private Long id;

    private Date purchaseDate;

    private BigDecimal totalValue;

    private BigDecimal discount;

    private BigDecimal additionalOperational;

    private List<FinalPaymentValueResponseDTO> finalPaymentValue;

    private List<OrderResponseDTO> order;
}
