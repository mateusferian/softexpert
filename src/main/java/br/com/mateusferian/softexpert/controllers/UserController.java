package br.com.mateusferian.softexpert.controllers;

import br.com.mateusferian.softexpert.dtos.requests.UserRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.UserResponseDTO;
import br.com.mateusferian.softexpert.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/softexpert/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping
    public List<UserResponseDTO> findAll(){
        return userFacade.findAll();
    }

    @PostMapping
    public UserResponseDTO save(@Valid  @RequestBody UserRequestDTO request){
        return userFacade.save(request);
    }
}
