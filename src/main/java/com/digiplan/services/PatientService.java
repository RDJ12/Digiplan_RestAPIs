package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Patient;

public interface PatientService {

	public Patient getPatient(String caseId);

	public List<Patient> getAllPatients();

	public Patient addPatient(Patient patientData);

	public Patient updatePatient(String caseId, Patient patientData);

	public String deletePatient(String caseId);
}
