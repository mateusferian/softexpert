package br.com.mateusferian.softexpert.mappers;

import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;
import br.com.mateusferian.softexpert.entities.PurchaseEntity;
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
public class PurchaseMapper {

    @Autowired
    private ModelMapper mapper;

    public PurchaseResponseDTO toDto(PurchaseEntity entity) {
        return mapper.map(entity, PurchaseResponseDTO.class);
    }

    public PurchaseEntity toEntity(PurchaseRequestDTO request){
        return mapper.map(request, PurchaseEntity.class);
    }

    public List<PurchaseResponseDTO> toDtoList(Iterable<PurchaseEntity> list){
        List<PurchaseEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return  result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
