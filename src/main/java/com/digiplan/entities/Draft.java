package com.digiplan.entities;

import java.util.Date;

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
@Table(name = "alignwise_drafts")
public class Draft {

	@Temporal(value = TemporalType.DATE)
	private Date savedOn;
	private String formData;
	private String savedBy;
	private Integer isActive;
	@Id
	private Integer id;

}
