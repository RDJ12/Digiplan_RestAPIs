package com.digiplan.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "FieldHandler" })
@NoArgsConstructor
@Table(name = "alignwise_query")
public class Query {

	@Id
	private String queryId;
	private String customerName;
	private Long phoneNumber;
	private String email;
	private String queryText;
	
}
