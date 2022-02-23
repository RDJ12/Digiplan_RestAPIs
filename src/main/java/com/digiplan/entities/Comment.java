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
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name = "comment_id")
	private Integer id;
	@Column(name = "case_id")
	private String caseId;
	@Column(name = "user_name")
	private String username;
	private String stage;
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

}
