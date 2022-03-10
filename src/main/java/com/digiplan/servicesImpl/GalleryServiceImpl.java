package com.digiplan.servicesImpl;

import com.digiplan.entities.Gallery;
import com.digiplan.repositories.GalleryRepository;
import com.digiplan.services.GalleryService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public JSONArray getSamples() {
        log.info("@Start myCases");
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        try {
            List<Gallery> galleryList = galleryRepository.findAll();
            for (Gallery gallery : galleryList) {
                JSONObject jsonObject = new JSONObject();
                JSONObject extractedData = (JSONObject) jsonParser.parse(gallery.getFormData());
                jsonObject.put("patientName", extractedData.get("PatientName"));
                jsonObject.put("serialNumber", extractedData.get("serialnumber"));
                jsonObject.put("dob", extractedData.get("DOB"));
                jsonObject.put("date", extractedData.get("date"));
                jsonObject.put("data", extractedData);
                jsonArray.add(jsonObject);
            }
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return jsonArray;
    }

}
