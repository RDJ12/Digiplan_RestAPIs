package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Image;
import com.digiplan.repositories.ImageRepository;
import com.digiplan.services.ImageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image getImage(Integer id) {
		log.info("@Start getImage");
		Image image = null;
		try {
			Optional<Image> check = imageRepository.findById(id);
			if (check.isPresent())
				image = imageRepository.getById(id);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return image;
	}

	@Override
	public List<Image> getAllImages() {
		log.info("@Start getAllImages");
		List<Image> imagesList = null;
		try {
			imagesList = imageRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return imagesList;
	}

	@Override
	public Image addImage(Image imageData) {
		log.info("@Start addImage");
		Image image = null;
		try {
			image = imageRepository.saveAndFlush(imageData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return image;
	}

	@Override
	public Image updateImage(Integer id, Image imageData) {
		log.info("@Start updateImage");
		Image image = null;
		try {
			Optional<Image> check = imageRepository.findById(id);
			if (check.isPresent())
				image = imageRepository.saveAndFlush(imageData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return image;
	}

	@Override
	public String deleteImage(Integer id) {
		log.info("@Start deleteDraft");
		String status = "";
		try {
			imageRepository.deleteById(id);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
