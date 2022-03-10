package com.digiplan.services;

import com.digiplan.entities.Gallery;
import org.json.simple.JSONArray;

import java.util.List;

public interface GalleryService {
    Gallery getGalleryData(String caseId);

    List<Gallery> getAllGalleryData();

    Gallery addGalleryData(Gallery galleryData);

    Gallery updateGalleryData(String caseId, Gallery galleryData);

    String deleteGalleryData(String caseId);

    JSONArray getSamples();
}
