package br.com.mateusferian.softexpert.repositories;

import br.com.mateusferian.softexpert.entities.DiscountEntity;
import org.springframework.data.repository.CrudRepository;

public interface EndUserValueRepository extends CrudRepository<DiscountEntity,Long> {
}
