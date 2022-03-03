package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Diagnosis;

public interface DiagnosisService {

	public Diagnosis getDiagnosisData(String id);

	public List<Diagnosis> getAllDiagnosisData();

	public Diagnosis addDiagnosisData(Diagnosis diagnosisData);

	public Diagnosis updateDiagnosisData(String id, Diagnosis diagnosisData);

	public String deleteDiagnosisData(String id);

}
