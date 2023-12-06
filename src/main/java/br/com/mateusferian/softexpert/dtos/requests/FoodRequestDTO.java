package br.com.mateusferian.softexpert.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestDTO {

    @NotBlank(message = "{white.field}")
    @Size(min = 3,max = 50, message = "{size.invalid}")
    private String name;

    @NotNull(message = "{null.field}")
    @Min(value = 1, message = "{below.the.minimum}")
    @Max(value = 250, message = "{above.the.maximum}")
    private BigDecimal value;

    @Override
    public String toString() {
        return "FoodRequestDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
