package br.com.mateusferian.softexpert.services;

import br.com.mateusferian.softexpert.entities.UserEntity;

public interface UserService {

    Iterable<UserEntity> findAll();

    UserEntity save(UserEntity entity);

    UserEntity findById(Long id);
}
