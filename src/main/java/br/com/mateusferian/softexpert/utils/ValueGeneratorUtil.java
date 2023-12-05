package br.com.mateusferian.softexpert.utils;

import br.com.mateusferian.softexpert.entities.DiscountEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.services.DiscountService;
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
    private DiscountService discountService;

    public List<DiscountEntity> finalValueGenerator(List<OrderEntity> orders) {
        List<DiscountEntity> discountEntities = new ArrayList<>();

        for (OrderEntity order : orders) {

            DiscountEntity discount = new DiscountEntity();
            BigDecimal foodCost = foodCalculatorUtil.calculateTotalFoodCosts(order.getFood());
            discount.setName(order.getUser().getName());
            discount.setValue(foodCost);

            discountEntities.add(discountService.save(discount));
        }

        return discountEntities;
    }
}
