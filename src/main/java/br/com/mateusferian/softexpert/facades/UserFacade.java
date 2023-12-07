package br.com.mateusferian.softexpert.facades;

import br.com.mateusferian.softexpert.dtos.requests.UserRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.UserResponseDTO;

import java.util.List;

public interface UserFacade {

    List<UserResponseDTO> findAll();

    UserResponseDTO save(UserRequestDTO request);
}
