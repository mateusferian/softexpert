package br.com.mateusferian.softexpert.repositories;

import br.com.mateusferian.softexpert.entities.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<PurchaseEntity,Long> {
}
