package com.digiplan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "alignwise_images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "draft_id")
	private Integer draftId;
	@Column(name = "form_id")
	private Integer formId;
	@Column(name = "folder_name")
	private String folderName;
	private String stage;
	private String side;
	private String front;
	private String frontSmiling;
	private String rightBuccal;
	private String leftBuccal;
	private String upperOcclusial;
	private String lowerOcclusial;
	private String frontal;
	private String opg;
	private String lateralCeph;
	private String other;
	@Column(name = "case_id")
	private String caseId;

}