package br.com.mateusferian.softexpert.entities;

import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameUser;

    private DeliveryTypeEnum deliveryType;

    private BigDecimal discount;

    private BigDecimal totalPayable;

    public PurchaseEntity(String nameUser, DeliveryTypeEnum deliveryType, BigDecimal discount, BigDecimal totalPayable) {
        this.nameUser = nameUser;
        this.deliveryType = deliveryType;
        this.discount = discount;
        this.totalPayable = totalPayable;
    }
}

