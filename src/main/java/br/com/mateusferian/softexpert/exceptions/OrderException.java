package br.com.mateusferian.softexpert.exceptions;

import br.com.mateusferian.softexpert.exceptions.enums.OrderEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class OrderException extends RuntimeException {

    public OrderException(OrderEnum error){
        super(error.getMessage());
        this.error =  error;
    }
    private final OrderEnum error;
}
