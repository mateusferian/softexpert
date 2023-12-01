package br.com.mateusferian.softexpert.services.impl;

import br.com.mateusferian.softexpert.entities.UserEntity;
import br.com.mateusferian.softexpert.repositories.UserRepository;
import br.com.mateusferian.softexpert.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserRepository userRepository;

    @Override
    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }
}
