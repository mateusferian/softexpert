package br.com.mateusferian.softexpert.repositories;

import br.com.mateusferian.softexpert.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
}
