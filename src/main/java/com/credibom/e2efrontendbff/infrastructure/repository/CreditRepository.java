package com.credibom.e2efrontendbff.infrastructure.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.credibom.e2efrontendbff.domain.model.internal.Credit;

public interface CreditRepository extends CrudRepository<Credit, Long> {

	public List<Credit> findCreditByKey(String key);
}
