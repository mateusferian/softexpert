package br.com.mateusferian.softexpert.repositories;

import br.com.mateusferian.softexpert.entities.FinalPaymentValueEntity;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<FinalPaymentValueEntity,Long> {
}
