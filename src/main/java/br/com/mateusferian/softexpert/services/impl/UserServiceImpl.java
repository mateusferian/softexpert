package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.UserEntity;
import br.com.mateusferian.softexpert.repositories.UserRepository;
import br.com.mateusferian.softexpert.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
     UserRepository userRepository;

    @Override
    public Iterable<UserEntity> findAll() {
        log.info("listing users");
        return userRepository.findAll();
    }

    @Override
    public UserEntity save(UserEntity entity) {
        log.info("registering a new user");
        return userRepository.save(entity);
    }
}
