package br.com.mateusferian.softexpert.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class TotalCalculatorUtil {

    public BigDecimal calculateTotal(BigDecimal order, BigDecimal delivery, BigDecimal discount) {

        order = (order == null) ? BigDecimal.ZERO : order;
        delivery = (delivery == null) ? BigDecimal.ZERO : delivery;
        discount = (discount == null) ? BigDecimal.ZERO : discount;

        BigDecimal totalValue = order.add(delivery).subtract(discount);

        return totalValue;
    }
}
