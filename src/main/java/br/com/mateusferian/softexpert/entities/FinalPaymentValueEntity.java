package br.com.mateusferian.softexpert.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalPaymentValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private BigDecimal GrossValue;

    private BigDecimal netValue;

    @Override
    public String toString() {
        return "FinalPaymentValueEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
