package com.digiplan.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "incompleteform")
public class IncompleteForm {

	@Id
	@Column(name = "form_id")
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date submittedOn;
	private String formData;
	private String submittedBy;
	private String patientName;
	private String remarks;
	private String flag;
	@Column(name = "doctor_name")
	private String doctorName;
	private String groupId;

}
