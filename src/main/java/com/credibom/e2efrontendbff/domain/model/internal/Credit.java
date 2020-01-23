package com.credibom.e2efrontendbff.domain.model.internal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Audited
@NoArgsConstructor
@AllArgsConstructor
@AuditTable("credit_history")
@Table(name = "credit", schema = "e2e")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Credit {

	@Id
	@GeneratedValue
	private Long id;

	private String key;

	private String value;
}
