package br.com.mateusferian.softexpert.exceptions;

import br.com.mateusferian.softexpert.exceptions.enums.UserEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class UserException extends RuntimeException {

    public UserException(UserEnum error){
        super(error.getMessage());
        this.error =  error;
    }
    private final UserEnum error;
}
