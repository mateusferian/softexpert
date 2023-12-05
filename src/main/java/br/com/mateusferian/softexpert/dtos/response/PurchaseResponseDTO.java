package br.com.mateusferian.softexpert.dtos.response;

import br.com.mateusferian.softexpert.entities.FinalPaymentValueEntity;
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

    private BigDecimal delivery;

    private List<FinalPaymentValueEntity> finalPaymentValue;

    private List<OrderResponseDTO> order;

}
