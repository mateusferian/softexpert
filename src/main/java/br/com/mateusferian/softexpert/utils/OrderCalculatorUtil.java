package br.com.mateusferian.softexpert.utils;

import br.com.mateusferian.softexpert.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public class OrderCalculatorUtil {

    @Autowired
    private FoodCalculatorUtil foodCalculatorUtil;

    public BigDecimal calculateTotalOrders(List<OrderEntity> orders) {
        BigDecimal valueOrders = BigDecimal.ZERO;

        for (OrderEntity order : orders) {
            valueOrders = valueOrders.add(foodCalculatorUtil.calculateTotalFoodCosts(order.getFood()));
        }

        return valueOrders;
    }
}
