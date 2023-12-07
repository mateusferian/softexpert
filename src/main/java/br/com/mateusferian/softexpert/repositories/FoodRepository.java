package br.com.mateusferian.softexpert.repositories;

import br.com.mateusferian.softexpert.entities.FoodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<FoodEntity,Long> {
}
