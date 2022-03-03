package com.digiplan.entities;

import java.time.LocalDate;

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
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
@NoArgsConstructor
@Table(name = "gallery")
public class Gallery {

    @Id
    private String caseId;
    private String submittedOn = LocalDate.now().toString();
    private String treatmentLink;
    private String downloadLink;
    private String formData;
    private String submittedBy;
    private String remarks;

}
