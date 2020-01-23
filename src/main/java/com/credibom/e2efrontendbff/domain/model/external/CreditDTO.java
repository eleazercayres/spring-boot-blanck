package com.credibom.e2efrontendbff.domain.model.external;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String value;
}
