package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Doctor;
import com.digiplan.repositories.DoctorRepository;
import com.digiplan.services.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor getDoctor(String caseId) {
		log.info("@Start getDoctor");
		Doctor doctor = null;
		try {
			Optional<Doctor> check = doctorRepository.findById(caseId);
			if (check.isPresent())
				doctor = doctorRepository.getById(caseId);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return doctor;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		log.info("@Start getAllDoctors");
		List<Doctor> doctorsList = null;
		try {
			doctorsList = doctorRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return doctorsList;
	}

	@Override
	public Doctor addDoctor(Doctor doctorData) {
		log.info("@Start addDoctor");
		Doctor doctor = null;
		try {
			doctor = doctorRepository.saveAndFlush(doctorData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return doctor;
	}

	@Override
	public Doctor updateDoctor(String caseId, Doctor doctorData) {
		log.info("@Start updateDoctor");
		Doctor doctor = null;
		try {
			Optional<Doctor> check = doctorRepository.findById(caseId);
			if (check.isPresent())
				doctor = doctorRepository.saveAndFlush(doctorData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return doctor;
	}

	@Override
	public String deleteDoctor(String caseId) {
		log.info("@Start deleteDoctor");
		String status = "";
		try {
			doctorRepository.deleteById(caseId);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
