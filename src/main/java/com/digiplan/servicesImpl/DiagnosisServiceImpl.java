package com.digiplan.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Diagnosis;
import com.digiplan.repositories.DiagnosisRepository;
import com.digiplan.services.DiagnosisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private DiagnosisRepository diagnosisRepository;

	@Override
	public Diagnosis getDiagnosisData(String id) {
		log.info("@Start getDiagnosisData");
		Diagnosis diagnosis = null;
		try {
			Optional<Diagnosis> check = diagnosisRepository.findById(id.replace('$', '/'));
			if (check.isPresent())
				diagnosis = diagnosisRepository.getById(id.replace('$', '/'));
		} catch (Exception exception) {
			System.out.println(exception);
			log.error("Exception = " + exception);
		}
		return diagnosis;
	}

	@Override
	public List<Diagnosis> getAllDiagnosisData() {
		log.info("@Start getAllDealerDiagnosisData");
		List<Diagnosis> diagnosisList = null;
		try {
			diagnosisList = diagnosisRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return diagnosisList;
	}

	@Override
	public Diagnosis addDiagnosisData(Diagnosis diagnosisData) {
		log.info("@Start addDiagnosisData");
		Diagnosis diagnosis = null;
		try {
			diagnosisData
					.setId(LocalDateTime.now() + "_" + UUID.randomUUID() + "_" + diagnosisData.getIncompleteFormId());
			diagnosis = diagnosisRepository.saveAndFlush(diagnosisData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return diagnosis;
	}

	@Override
	public Diagnosis updateDiagnosisData(String id, Diagnosis diagnosisData) {
		log.info("@Start updateDiagnosisData");
		Diagnosis diagnosis = null;
		try {
			Optional<Diagnosis> check = diagnosisRepository.findById(id.replace('$', '/'));
			if (check.isPresent())
				diagnosis = diagnosisRepository.saveAndFlush(diagnosisData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return diagnosis;
	}

	@Override
	public String deleteDiagnosisData(String id) {
		log.info("@Start deleteDiagnosisData");
		String status = "";
		try {
			diagnosisRepository.deleteById(id.replace('$', '/'));
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
