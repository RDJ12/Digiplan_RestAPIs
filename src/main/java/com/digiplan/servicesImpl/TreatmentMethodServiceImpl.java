package com.digiplan.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.TreatmentMethod;
import com.digiplan.repositories.TreatmentMethodRepository;
import com.digiplan.services.TreatmentMethodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TreatmentMethodServiceImpl implements TreatmentMethodService {

	@Autowired
	private TreatmentMethodRepository treatmentMethodRepository;

	@Override
	public TreatmentMethod getTreatmentMethodData(String id) {
		log.info("@Start getTreatmentMethodData");
		TreatmentMethod treatmentMethod = null;
		try {
			Optional<TreatmentMethod> check = treatmentMethodRepository.findById(id.replace('$', '/'));
			if (check.isPresent())
				treatmentMethod = treatmentMethodRepository.getById(id.replace('$', '/'));
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return treatmentMethod;
	}

	@Override
	public List<TreatmentMethod> getAllTreatmentMethodData() {
		log.info("@Start getAllTreatmentMethodData");
		List<TreatmentMethod> treatmentMethodList = null;
		try {
			treatmentMethodList = treatmentMethodRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return treatmentMethodList;
	}

	@Override
	public TreatmentMethod addTreatmentMethodData(TreatmentMethod treatmentMethodData) {
		log.info("@Start addTreatmentMethodData");
		TreatmentMethod treatmentMethod = null;
		try {
			treatmentMethodData.setId(
					LocalDateTime.now() + "_" + UUID.randomUUID() + "_" + treatmentMethodData.getIncompleteFormId());
			treatmentMethod = treatmentMethodRepository.saveAndFlush(treatmentMethodData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return treatmentMethod;
	}

	@Override
	public TreatmentMethod updateTreatmentMethodData(String id, TreatmentMethod treatmentMethodData) {
		log.info("@Start updateTreatmentMethodData");
		TreatmentMethod treatmentMethod = null;
		try {
			Optional<TreatmentMethod> check = treatmentMethodRepository.findById(id.replace('$', '/'));
			if (check.isPresent())
				treatmentMethod = treatmentMethodRepository.saveAndFlush(treatmentMethodData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return treatmentMethod;
	}

	@Override
	public String deleteTreatmentMethodData(String id) {
		log.info("@Start deleteTreatmentMethodData");
		String status = "";
		try {
			treatmentMethodRepository.deleteById(id.replace('$', '/'));
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
