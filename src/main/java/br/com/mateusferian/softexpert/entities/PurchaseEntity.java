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
            name = "purchase_final_payment_value_mapping",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "final_payment_value_id")
    )
    private List<FinalPaymentValueEntity> finalPaymentValue;

    @ManyToMany
    @JoinTable(
            name = "purchase_order_mapping",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderEntity> order;

    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                ", finalPaymentValue=" + finalPaymentValue +
                ", order=" + order +
                '}';
    }
}



