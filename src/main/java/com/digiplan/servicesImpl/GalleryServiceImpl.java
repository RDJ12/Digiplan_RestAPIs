package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Gallery;
import com.digiplan.repositories.GalleryRepository;
import com.digiplan.services.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GalleryServiceImpl implements GalleryService {
	@Autowired
	private GalleryRepository galleryRepository;

	@Override
	public Gallery getGalleryData(String caseId) {
		log.info("@Start getGalleryData");
		Gallery gallery = null;
		try {
			Optional<Gallery> check = galleryRepository.findById(caseId);
			if (check.isPresent())
				gallery = galleryRepository.getById(caseId);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return gallery;
	}

	@Override
	public List<Gallery> getAllGalleryData() {
		log.info("@Start getAllGalleryData");
		List<Gallery> galleryList = null;
		try {
			galleryList = galleryRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return galleryList;
	}

	@Override
	public Gallery addGalleryData(Gallery galleryData) {
		log.info("@Start addGalleryData");
		Gallery gallery = null;
		try {
			gallery = galleryRepository.saveAndFlush(galleryData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return gallery;
	}

	@Override
	public Gallery updateGalleryData(String caseId, Gallery galleryData) {
		log.info("@Start updateGalleryData");
		Gallery gallery = null;
		try {
			Optional<Gallery> check = galleryRepository.findById(caseId);
			if (check.isPresent())
				gallery = galleryRepository.saveAndFlush(galleryData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return gallery;
	}

	@Override
	public String deleteGalleryData(String caseId) {
		log.info("@Start deleteGalleryData");
		String status = "";
		try {
			galleryRepository.deleteById(caseId);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
