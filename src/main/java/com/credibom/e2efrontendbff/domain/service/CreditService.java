package com.credibom.e2efrontendbff.domain.service;

import java.util.List;

import com.credibom.e2efrontendbff.domain.model.external.CreditDTO;

public interface CreditService {

	List<CreditDTO> findCredit(String creditValue);

	List<CreditDTO> findCreditCampaign(String creditValue);
}
