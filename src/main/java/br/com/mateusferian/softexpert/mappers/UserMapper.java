package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.requests.UserRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.dtos.response.UserResponseDTO;
import br.com.mateusferian.softexpert.entities.OrderEntity;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import br.com.mateusferian.softexpert.entities.UserEntity;
import br.com.mateusferian.softexpert.repositories.PurchaseRepository;
import br.com.mateusferian.softexpert.repositories.UserRepository;
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
public class UserMapper {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO toDto(UserEntity entity) {
        return mapper.map(entity, UserResponseDTO.class);
    }

    public UserEntity toEntity(UserRequestDTO request){
        return mapper.map(request,UserEntity.class);
    }

    public List<UserResponseDTO> toDtoList(Iterable<UserEntity> list){
        List<UserEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
