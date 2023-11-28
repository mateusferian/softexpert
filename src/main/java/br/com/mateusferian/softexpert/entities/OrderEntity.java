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
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameOrder;

    private BigDecimal value;

    @ManyToOne
    private PurchaseEntity purchase;

    public OrderEntity(String nameOrder, BigDecimal value, PurchaseEntity purchase) {
        this.nameOrder = nameOrder;
        this.value = value;
        this.purchase = purchase;
    }
}

