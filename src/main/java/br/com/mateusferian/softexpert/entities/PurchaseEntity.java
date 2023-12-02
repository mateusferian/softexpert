package br.com.mateusferian.softexpert.entities;

import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date RequestDate;

    private BigDecimal totalValue;

    private BigDecimal discount;

    private BigDecimal delivery;

    @ManyToOne
    private OrderEntity order;

}

