package br.com.mateusferian.softexpert.facades.impl;

import br.com.mateusferian.softexpert.dtos.requests.UserRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.UserResponseDTO;
import br.com.mateusferian.softexpert.facades.UserFacade;
import br.com.mateusferian.softexpert.mappers.UserMapper;
import br.com.mateusferian.softexpert.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public List<UserResponseDTO> findAll() {
        return mapper.toDtoList(userService.findAll());
    }

    @Override
    public UserResponseDTO save(UserRequestDTO request) {
        return mapper.toDto(userService.save(mapper.toEntity(request)));
    }
}
