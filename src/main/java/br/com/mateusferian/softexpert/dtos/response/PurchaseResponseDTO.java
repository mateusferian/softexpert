package br.com.mateusferian.softexpert.dtos.response;

import br.com.mateusferian.softexpert.entities.DiscountEntity;
import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDTO {

    private Long id;

    private Date RequestDate;

    private BigDecimal totalValue;

    private BigDecimal discount;

    private BigDecimal delivery;

    private List<DiscountEntity> discountList;

    private List<OrderResponseDTO> order;

}
