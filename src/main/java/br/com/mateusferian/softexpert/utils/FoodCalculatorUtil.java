package br.com.mateusferian.softexpert.utils;

import br.com.mateusferian.softexpert.entities.FoodEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public class FoodCalculatorUtil {

    public BigDecimal calculateTotalFoodCosts(List<FoodEntity> foods) {
        BigDecimal valueFoods = BigDecimal.ZERO;

        for (FoodEntity food : foods) {
            valueFoods = valueFoods.add(food.getValue());
        }

        return valueFoods;
    }
}
