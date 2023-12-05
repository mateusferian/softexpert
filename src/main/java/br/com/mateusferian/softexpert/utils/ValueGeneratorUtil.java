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

    public List<FinalPaymentValueEntity> finalValueGenerator(List<OrderEntity> orders) {
        List<FinalPaymentValueEntity> finalPaymentValueEntities = new ArrayList<>();

        for (OrderEntity order : orders) {

            FinalPaymentValueEntity finalPaymentValue = new FinalPaymentValueEntity();
            BigDecimal foodCost = foodCalculatorUtil.calculateTotalFoodCosts(order.getFood());
            finalPaymentValue.setName(order.getUser().getName());
            finalPaymentValue.setValue(foodCost);

            finalPaymentValueEntities.add(finalPaymentValueService.save(finalPaymentValue));
        }

        return finalPaymentValueEntities;
    }
}
