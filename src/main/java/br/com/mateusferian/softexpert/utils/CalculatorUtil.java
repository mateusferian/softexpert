package br.com.mateusferian.softexpert.utils;

import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CalculatorUtil {

    public BigDecimal calculatingTotalPurchase(BigDecimal order, BigDecimal additionalOperational, BigDecimal discount) {

        order = (order == null) ? BigDecimal.ZERO : order;
        additionalOperational = (additionalOperational == null) ? BigDecimal.ZERO : additionalOperational;
        discount = (discount == null) ? BigDecimal.ZERO : discount;

        BigDecimal totalDiscount = order.subtract(discount);
        BigDecimal totalPurchase = totalDiscount.add(additionalOperational);

        return totalPurchase;
    }

    public BigDecimal calculatingValueForEachUser(BigDecimal foodValue, BigDecimal ordersValue, BigDecimal discount , BigDecimal additionalOperational) {

        BigDecimal totalPurchase = calculatingTotalPurchase(ordersValue, additionalOperational, discount);

        BigDecimal proportionValue = foodValue.divide(ordersValue, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal finalValue = totalPurchase.multiply(proportionValue);

        BigDecimal result = finalValue.setScale(2, BigDecimal.ROUND_HALF_UP);

        return result;
    }

    public BigDecimal calculateTotalOrders(List<OrderEntity> orders) {
        BigDecimal valueOrders = BigDecimal.ZERO;

        for (OrderEntity order : orders) {
            valueOrders = valueOrders.add(order.getTotalOrder());
        }

        return valueOrders;
    }

    public BigDecimal calculateTotalFoodValue(List<FoodEntity> foods) {
        BigDecimal valueFoods = BigDecimal.ZERO;

        for (FoodEntity food : foods) {
            valueFoods = valueFoods.add(food.getValue());
        }

        return valueFoods;
    }
}
