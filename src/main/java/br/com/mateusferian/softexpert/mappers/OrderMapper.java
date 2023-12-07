package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.exceptions.FoodException;
import br.com.mateusferian.softexpert.exceptions.enums.FoodEnum;
import br.com.mateusferian.softexpert.services.FoodService;
import br.com.mateusferian.softexpert.services.UserService;
import br.com.mateusferian.softexpert.utils.CalculatorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private CalculatorUtil calculatorUtil;

    public OrderResponseDTO toDto(OrderEntity entity) {
        log.info("converting entity{} to dto", entity);
        return mapper.map(entity, OrderResponseDTO.class);
    }

    public OrderEntity toEntity(OrderRequestDTO request) {
        log.info("converting dto{} to entity", request);
        OrderEntity order = mapper.map(request, OrderEntity.class);

            order.setRequestDate(new Date());
        List<Long> foodIds = request.getFood();
        List<FoodEntity> foods = (List<FoodEntity>) foodService.findAllById(foodIds);
        order.setFood(foods);

        List<Long> foundIds = foods.stream().map(FoodEntity::getId).collect(Collectors.toList());
        List<Long> notFoundIds = foodIds.stream().filter(id -> !foundIds.contains(id)).collect(Collectors.toList());

        if(!notFoundIds.isEmpty()) {
            throw  new FoodException(FoodEnum.SOME_OF_THE_FOOD_WERE_NOT_FOUND);
        }

        order.setTotalOrder(calculatorUtil.calculateTotalFoodValue(order.getFood()));
            order.setUser(userService.findById(request.getUser()));

        return order;
    }

    public List<OrderResponseDTO> toDtoList(Iterable<OrderEntity> list){
        log.info("converting entity list{} to dto list", list);
        List<OrderEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
