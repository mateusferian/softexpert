package br.com.mateusferian.softexpert.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum OrderEnum {

    SOME_OF_ORDERS_NOT_FOUND("SOME_OF_ORDERS_NOT_FOUND","some orders were not found",400);

    private String code;
    private String message;
    private Integer statusCode;
}
