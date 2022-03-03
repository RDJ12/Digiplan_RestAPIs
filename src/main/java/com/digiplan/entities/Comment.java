package com.digiplan.entities;

import java.time.LocalDateTime;

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
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Integer id;
	@Column(name = "case_id")
	private String caseId;
	@Column(name = "user_name")
	private String username;
	private String stage;
	private String comment;
	private LocalDateTime date = LocalDateTime.now();

}
