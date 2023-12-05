package br.com.mateusferian.softexpert.utils;

import br.com.mateusferian.softexpert.entities.FinalPaymentValueEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.services.FinalPaymentValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class ValueGeneratorUtil {

    @Autowired
    private FinalPaymentValueService finalPaymentValueService;

    @Autowired
    private CalculatorUtil calculatorUtil;

    public List<FinalPaymentValueEntity> finalValueGenerator(List<OrderEntity> orders, BigDecimal discount, BigDecimal delivery) {
        List<FinalPaymentValueEntity> finalPaymentValueEntities = new ArrayList<>();

        for (OrderEntity order : orders) {

            FinalPaymentValueEntity finalPaymentValue = new FinalPaymentValueEntity();
            BigDecimal foodValue = order.getTotalOrder();
            BigDecimal ordersValue = calculatorUtil.calculateTotalOrders(orders);

            finalPaymentValue.setName(order.getUser().getName());
            finalPaymentValue.setGrossValue(foodValue);
            finalPaymentValue.setNetValue(calculatorUtil.calculatingValueForEachUser(foodValue,ordersValue, discount,delivery));

            finalPaymentValueEntities.add(finalPaymentValueService.save(finalPaymentValue));
        }

        return finalPaymentValueEntities;
    }
}
