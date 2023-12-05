package br.com.mateusferian.softexpert.entities;

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

    private Date purchaseDate;

    private BigDecimal totalValue;

    private BigDecimal discount;

    private BigDecimal delivery;

    @ManyToMany
    @JoinTable(
            name = "purchase_discount_mapping",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    private List<DiscountEntity> finalPaymentValue;

    @ManyToMany
    @JoinTable(
            name = "purchase_order_mapping",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderEntity> order;
}

