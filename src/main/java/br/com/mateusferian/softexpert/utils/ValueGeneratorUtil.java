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
    private FoodCalculatorUtil foodCalculatorUtil;

    @Autowired
    private FinalPaymentValueService finalPaymentValueService;

    @Autowired
    private OrderCalculatorUtil orderCalculatorUtil;

    public List<FinalPaymentValueEntity> finalValueGenerator(List<OrderEntity> orders, BigDecimal discount, BigDecimal delivery) {
        List<FinalPaymentValueEntity> finalPaymentValueEntities = new ArrayList<>();

        for (OrderEntity order : orders) {

            FinalPaymentValueEntity finalPaymentValue = new FinalPaymentValueEntity();
            BigDecimal foodValue = foodCalculatorUtil.calculateTotalFoodCosts(order.getFood());
            BigDecimal ordersValue = orderCalculatorUtil.calculateTotalOrders(orders);

            finalPaymentValue.setName(order.getUser().getName());
            finalPaymentValue.setValue(calculatingValueForEachUser(foodValue,ordersValue, discount,delivery));

            finalPaymentValueEntities.add(finalPaymentValueService.save(finalPaymentValue));
        }

        return finalPaymentValueEntities;
    }
    public  BigDecimal calculatingValueForEachUser(BigDecimal valorA, BigDecimal ordersValue, BigDecimal discount , BigDecimal delivery) {

        BigDecimal totalDiscount = ordersValue.subtract(discount);

        BigDecimal totalWithAddition = totalDiscount.add(delivery);

        BigDecimal proportionValue = valorA.divide(ordersValue, 2, BigDecimal.ROUND_HALF_UP);

        BigDecimal valorFinalA = totalWithAddition.multiply(proportionValue);

        BigDecimal result = valorFinalA.setScale(2, BigDecimal.ROUND_HALF_UP);

        return  result;
    }
}
