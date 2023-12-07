package br.com.mateusferian.softexpert.repositories;

import br.com.mateusferian.softexpert.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
