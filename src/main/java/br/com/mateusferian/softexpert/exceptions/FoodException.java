package br.com.mateusferian.softexpert.exceptions;

import br.com.mateusferian.softexpert.exceptions.enums.FoodEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class FoodException extends RuntimeException{

    public FoodException(FoodEnum error){
        super(error.getMessage());
        this.error =  error;
    }
    private final FoodEnum error;
}
