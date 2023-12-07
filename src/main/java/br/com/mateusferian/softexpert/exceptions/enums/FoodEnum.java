package br.com.mateusferian.softexpert.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum FoodEnum {

    SOME_OF_THE_FOOD_WERE_NOT_FOUND("SOME_OF_THE_FOOD_WERE_NOT_FOUND","some foods were not found",400);

    private String code;
    private String message;
    private Integer statusCode;
}
