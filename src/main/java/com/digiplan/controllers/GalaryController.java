package com.digiplan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digiplan.entities.Gallery;
import com.digiplan.services.GalleryService;

@RestController
public class GalaryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/getGalleryData/{caseId}")
    public ResponseEntity<Gallery> getGalleryData(@PathVariable String caseId) {
        Gallery gallery = this.galleryService.getGalleryData(caseId);
        if (gallery != null)
            return new ResponseEntity<Gallery>(gallery, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllGalleryData")
    public List<Gallery> getAllGalleryData() {
        return this.galleryService.getAllGalleryData();
    }

    @PostMapping("/addGalleryData")
    public ResponseEntity<Gallery> addGalleryData(@RequestBody Gallery galleryData) {
        return new ResponseEntity<Gallery>(this.galleryService.addGalleryData(galleryData), HttpStatus.CREATED);
    }

    @PutMapping("/updateGalleryData/{caseId}")
    public ResponseEntity<Gallery> updateGalleryData(@PathVariable String caseId, @RequestBody Gallery galleryData) {
        Gallery gallery = this.galleryService.updateGalleryData(caseId, galleryData);
        if (gallery != null)
            return new ResponseEntity<Gallery>(gallery, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteGalleryData/{caseId}")
    public ResponseEntity<String> deleteGalleryData(@PathVariable String caseId) {
        String status = this.galleryService.deleteGalleryData(caseId);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
