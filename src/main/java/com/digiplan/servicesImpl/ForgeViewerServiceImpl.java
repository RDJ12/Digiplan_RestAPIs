package com.digiplan.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.ForgeViewer;
import com.digiplan.repositories.ForgeViewerRepository;
import com.digiplan.services.ForgeViewerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ForgeViewerServiceImpl implements ForgeViewerService {

	@Autowired
	private ForgeViewerRepository forgeViewerRepository;

	@Override
	public ForgeViewer getForgeViewer(Integer id) {
		log.info("@Start getForgeViewer");
		ForgeViewer forgeViewer = null;
		try {
			Optional<ForgeViewer> check = forgeViewerRepository.findById(id);
			if (check.isPresent())
				forgeViewer = forgeViewerRepository.getById(id);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return forgeViewer;
	}

	@Override
	public List<ForgeViewer> getAllForgeViewers() {
		log.info("@Start getAllForgeViewers");
		List<ForgeViewer> forgeViewersList = null;
		try {
			forgeViewersList = forgeViewerRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return forgeViewersList;
	}

	@Override
	public ForgeViewer addForgeViewer(ForgeViewer forgeViewerData) {
		log.info("@Start addForgeViewer");
		ForgeViewer forgeViewer = null;
		try {
			forgeViewerData.setCreateDate(LocalDateTime.now());
			forgeViewer = forgeViewerRepository.saveAndFlush(forgeViewerData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return forgeViewer;
	}

	@Override
	public ForgeViewer updateForgeViewer(Integer id, ForgeViewer forgeViewerData) {
		log.info("@Start updateForgeViewer");
		ForgeViewer forgeViewer = null;
		try {
			forgeViewerData.setUpdatedDate(LocalDateTime.now());
			Optional<ForgeViewer> check = forgeViewerRepository.findById(id);
			if (check.isPresent())
				forgeViewer = forgeViewerRepository.saveAndFlush(forgeViewerData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return forgeViewer;
	}

	@Override
	public String deleteForgeViewer(Integer id) {
		log.info("@Start deleteForgeViewer");
		String status = "";
		try {
			forgeViewerRepository.deleteById(id);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
