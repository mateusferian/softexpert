package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.UserEntity;
import br.com.mateusferian.softexpert.repositories.FoodRepository;
import br.com.mateusferian.softexpert.repositories.OrderRepository;
import br.com.mateusferian.softexpert.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
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
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    public OrderResponseDTO toDto(OrderEntity entity) {
        log.info("converting entity{} to dto", entity);
        return mapper.map(entity, OrderResponseDTO.class);
    }

    public OrderEntity toEntity(OrderRequestDTO request) {
        log.info("converting dto{} to entity", request);
        OrderEntity order = mapper.map(request, OrderEntity.class);

            order.setRequestDate(new Date());
        List<Long> foodIds = request.getFood();
        List<FoodEntity> foods = (List<FoodEntity>) foodRepository.findAllById(foodIds);
        order.setFood(foods);

            order.setUser(userRepository.findById(request.getUser()).orElse(new UserEntity()));

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
