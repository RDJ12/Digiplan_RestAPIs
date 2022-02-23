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
@Table(name = "forge_viewer_data")
public class ForgeViewer {

	@Id
	@Column(name = "item_id")
	private Integer id;
	private String caseId;
	private String type1;
	private String type2;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createDate;
	@Column(name = "updated_date")
	private Date updatedDate;
	@Column(name = "forge_viewer_link")
	private String forgeViewerLink;

}
