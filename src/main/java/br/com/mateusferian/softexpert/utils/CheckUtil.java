package br.com.mateusferian.softexpert.utils;

import br.com.mateusferian.softexpert.enums.OperationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CheckUtil {

    @Autowired
    private CalculatorUtil calculatorUtil;

    public BigDecimal operationTypeCheck(OperationTypeEnum operationType, BigDecimal additionalOperational, BigDecimal valueTotalOrders){
        BigDecimal valueOfTheIncrease = null;

        if(operationType == OperationTypeEnum.OPERATION_IN_VALUE) {
            valueOfTheIncrease = additionalOperational;

        }else if(operationType == OperationTypeEnum.OPERATION_IN_PERCENTAGE) {

            valueOfTheIncrease = calculatorUtil.calculatingPercentageOfTotal(additionalOperational, valueTotalOrders);

        }
        return valueOfTheIncrease;
    }
}
