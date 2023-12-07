package br.com.mateusferian.softexpert.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UserEnum {

    USER_NOT_FOUND("USER_NOT_FOUND","user not found",400);

    private String code;
    private String message;
    private Integer statusCode;
}
