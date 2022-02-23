package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Doctor;

public interface DoctorService {

	public Doctor getDoctor(String caseId);

	public List<Doctor> getAllDoctors();

	public Doctor addDoctor(Doctor doctorData);

	public Doctor updateDoctor(String caseId, Doctor doctorData);

	public String deleteDoctor(String caseId);
}
