package br.com.mateusferian.softexpert.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestDTO {

    private String name;

    private BigDecimal value;

    @Override
    public String toString() {
        return "FoodRequestDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
