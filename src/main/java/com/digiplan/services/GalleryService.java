package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Gallery;

public interface GalleryService {
	public Gallery getGalleryData(String caseId);

	public List<Gallery> getAllGalleryData();

	public Gallery addGalleryData(Gallery galleryData);

	public Gallery updateGalleryData(String caseId, Gallery galleryData);

	public String deleteGalleryData(String caseId);
}
