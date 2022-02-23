package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Patient;
import com.digiplan.repositories.PatientRepository;
import com.digiplan.services.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient getPatient(String caseId) {
		log.info("@Start getPatient");
		Patient patient = null;
		try {
			patient = patientRepository.getById(caseId);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return patient;
	}

	@Override
	public List<Patient> getAllPatients() {
		log.info("@Start getAllPatients");
		List<Patient> patientsList = null;
		try {
			patientsList = patientRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return patientsList;
	}

	@Override
	public Patient addPatient(Patient patientData) {
		log.info("@Start addPatient");
		Patient patient = null;
		try {
			patient = patientRepository.saveAndFlush(patientData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return patient;
	}

	@Override
	public Patient updatePatient(String caseId, Patient patientData) {
		log.info("@Start updatePatient");
		Patient patient = null;
		try {
			Optional<Patient> check = patientRepository.findById(caseId);
			if (check.isPresent())
				patient = patientRepository.saveAndFlush(patientData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return patient;
	}

	@Override
	public String deletePatient(String caseId) {
		log.info("@Start deletePatient");
		String status = "";
		try {
			patientRepository.deleteById(caseId);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
