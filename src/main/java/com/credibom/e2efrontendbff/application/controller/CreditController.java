package com.credibom.e2efrontendbff.application.controller;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibom.e2efrontendbff.domain.model.external.CreditDTO;
import com.credibom.e2efrontendbff.domain.service.CreditService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("credit")
public class CreditController {
	
    private CreditService creditService;
    
	@GetMapping(params = { "creditValue" })
    public ResponseEntity<List<CreditDTO>> findCredit(@RequestParam("creditValue") String creditValue) {
    	List<CreditDTO> result = creditService.findCredit(creditValue);
        return CollectionUtils.isNotEmpty(result) ? ok(result) : notFound().build();
    }
	
	@GetMapping(path = "/campaign", params = { "creditValue" })
    public ResponseEntity<List<CreditDTO>> findCreditCampaign(@RequestParam("creditValue") String creditValue) {
    	List<CreditDTO> result = creditService.findCreditCampaign(creditValue);
        return CollectionUtils.isNotEmpty(result) ? ok(result) : notFound().build();
    }
	
}
