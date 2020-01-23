package com.credibom.e2efrontendbff.domain.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.credibom.e2efrontendbff.domain.model.external.CreditDTO;
import com.credibom.e2efrontendbff.domain.model.internal.Credit;
import com.credibom.e2efrontendbff.domain.service.CreditService;
import com.credibom.e2efrontendbff.infrastructure.api.ServiceCreditAPI;
import com.credibom.e2efrontendbff.infrastructure.repository.CreditRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@org.springframework.stereotype.Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	private CreditRepository creditRepository;
	@Autowired
	private ServiceCreditAPI serviceCreditAPI;

	@Override
	public List<CreditDTO> findCredit(String creditValue) {

		if (Objects.isNull(creditValue)) {
			log.error("Credito nao encontrado para o valor {}", creditValue);
			return Collections.emptyList();
		}

		return serviceCreditAPI.findCreditCampaign(creditValue);
	}

	@Override
	public List<CreditDTO> findCreditCampaign(String creditValue) {

		List<Credit> credits = null;
		try {

			if (Objects.isNull(creditValue)) {
				log.error("Credito nao encontrado para o valor {}", creditValue);
				return Collections.emptyList();
			}

			if (Long.valueOf(creditValue) > 100) {
				credits = creditRepository.findCreditByKey("promo2");
			} else {
				credits = creditRepository.findCreditByKey("promo1");
			}

		} catch (Exception e) {
			log.error("Não foi possivel retornar uma lista de credito para o valor creditValue {}", creditValue);
		}
		return parseCreditsToCreditDTO(credits);
	}

	private List<CreditDTO> parseCreditsToCreditDTO(List<Credit> credits) {
		List<CreditDTO> resultList = null;
		if (CollectionUtils.isNotEmpty(credits)) {
			resultList = credits.stream().map(element -> new CreditDTO(element.getId(), element.getValue()))
					.collect(Collectors.toList());
		}
		return resultList;
	}

}