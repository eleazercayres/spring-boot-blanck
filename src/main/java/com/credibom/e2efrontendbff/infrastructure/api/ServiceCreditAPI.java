package com.credibom.e2efrontendbff.infrastructure.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.credibom.e2efrontendbff.domain.model.external.CreditDTO;
import com.credibom.e2efrontendbff.infrastructure.api.pool.CreditConfigurerPoolConfig;
import com.credibom.e2efrontendbff.infrastructure.exception.CreditException;
import com.credibom.e2efrontendbff.infrastructure.exception.IntegrationException;

import feign.Response;
import feign.codec.ErrorDecoder;

@FeignClient(value = "creditservice-api", url = "${application.creditservice.url}", configuration =  {
		ServiceCreditAPI.CreditDecoder.class, CreditConfigurerPoolConfig.class }
)
public interface ServiceCreditAPI {

    @GetMapping("/credit/campaign")
	List<CreditDTO> findCreditCampaign(@RequestParam("creditValue") String serviceId);

	class CreditDecoder implements ErrorDecoder {
		@Override
		public IntegrationException decode(String methodKey, Response response) {

			final HttpStatus statusCode = HttpStatus.valueOf(response.status());

			final String message = String.format("Falha de integracao com o Service Configurer: method: %s, httpStatus: %d",
					methodKey, statusCode.value());

			throw new CreditException(message, statusCode);
		}
	}
}
