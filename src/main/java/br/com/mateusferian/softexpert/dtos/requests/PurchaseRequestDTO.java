package br.com.mateusferian.softexpert.dtos.requests;

import br.com.mateusferian.softexpert.enums.OperationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDTO {

    @NotEmpty(message = "{empty.list}")
    private List<Long> order;

    @NotNull(message = "{null.field}")
    @Min(value = 1, message = "{below.the.minimum}")
    @Max(value = 250, message = "{above.the.maximum}")
    private BigDecimal discount;

    private OperationTypeEnum operationType;

    @NotNull(message = "{null.field}")
    @Min(value = 1, message = "{below.the.minimum}")
    @Max(value = 250, message = "{above.the.maximum}")
    private BigDecimal additionalOperational;

    @Override
    public String toString() {
        return "PurchaseRequestDTO{" +
                "order=" + order +
                '}';
    }
}

