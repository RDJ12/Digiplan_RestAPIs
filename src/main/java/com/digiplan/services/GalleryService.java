package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Gallery;

public interface GalleryService {
    Gallery getGalleryData(String caseId);

    List<Gallery> getAllGalleryData();

    Gallery addGalleryData(Gallery galleryData);

    Gallery updateGalleryData(String caseId, Gallery galleryData);

    String deleteGalleryData(String caseId);
}
