package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.entities.FoodEntity;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.repositories.FoodRepository;
import br.com.mateusferian.softexpert.repositories.OrderRepository;
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
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    public OrderResponseDTO toDto(OrderEntity entity) {
        return mapper.map(entity, OrderResponseDTO.class);
    }

    public OrderEntity toEntity(OrderRequestDTO request) {

        OrderEntity order = mapper.map(request, OrderEntity.class);
            order.setRequestDate(new Date());
            order.setFood(foodRepository.findById(request.getFood()).orElse(new FoodEntity()));
            order.setUser(userRepository.findById(request.getUser()).orElse(new UserEntity()));

        return order;
    }

    public List<OrderResponseDTO> toDtoList(Iterable<OrderEntity> list){
        List<OrderEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
