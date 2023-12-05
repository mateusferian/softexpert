package br.com.mateusferian.softexpert.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalPaymentValueResponseDTO {

    private Long id;

    private String name;

    private BigDecimal value;

    @Override
    public String toString() {
        return "FinalPaymentValueEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
