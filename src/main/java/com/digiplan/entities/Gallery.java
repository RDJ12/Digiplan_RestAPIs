package com.digiplan.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "gallery")
public class Gallery {

	@Id
	private String caseId;
	private String submittedOn;
	private String treatmentLink;
	private String downloadLink;
	private String formData;
	private String submittedBy;
	private String remarks;

}
