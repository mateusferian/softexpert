package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.FoodRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.FoodResponseDTO;
import br.com.mateusferian.softexpert.entities.FoodEntity;
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
public class FoodMapper {

    @Autowired
    private ModelMapper mapper;

    public FoodResponseDTO toDto(FoodEntity entity) {
        log.info("converting entity{} to dto", entity);
        return mapper.map(entity, FoodResponseDTO.class);
    }

    public FoodEntity toEntity(FoodRequestDTO request){
        log.info("converting dto{} to entity", request);
        return mapper.map(request, FoodEntity.class);
    }

    public List<FoodResponseDTO> toDtoList(Iterable<FoodEntity> list){
        log.info("converting entity list{} to dto list", list);
        List<FoodEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
