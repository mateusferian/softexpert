package br.com.mateusferian.softexpert.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum OperationTypeEnum {

    OPERATION_IN_PERCENTAGE("percentage_operation"),
    OPERATION_IN_VALUE("operation_in_value");

    private String status;
}
