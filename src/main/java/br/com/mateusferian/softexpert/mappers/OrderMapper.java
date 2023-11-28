package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PurchaseRepository purchaseRepository;

    public OrderResponseDTO toDto(OrderEntity entity) {
        return mapper.map(entity, OrderResponseDTO.class);
    }

    public OrderEntity toEntity(OrderRequestDTO request){
        OrderEntity orderEntity = mapper.map(request,OrderEntity.class);
        orderEntity.setPurchase(purchaseRepository.findById(request.getPurchase()).orElse(new PurchaseEntity()));

        return orderEntity;
    }

    public List<OrderResponseDTO> toDtoList(Iterable<OrderEntity> list){
        List<OrderEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
