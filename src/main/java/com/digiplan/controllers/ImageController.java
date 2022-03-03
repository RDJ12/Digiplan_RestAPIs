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

import com.digiplan.entities.Image;
import com.digiplan.services.ImageService;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/getImage/{id}")
    public ResponseEntity<Image> getImage(@PathVariable Integer id) {
        Image image = this.imageService.getImage(id);
        if (image != null)
            return new ResponseEntity<Image>(image, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllImages")
    public List<Image> getAllImages() {
        return this.imageService.getAllImages();
    }

    @PostMapping("/addImage")
    public ResponseEntity<Image> addDraft(@RequestBody Image imageData) {
        return new ResponseEntity<Image>(this.imageService.addImage(imageData), HttpStatus.CREATED);
    }

    @PutMapping("/updateImage/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Integer id, @RequestBody Image imageData) {
        Image image = this.imageService.updateImage(id, imageData);
        if (image != null)
            return new ResponseEntity<Image>(image, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteImage/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Integer id) {
        String status = this.imageService.deleteImage(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
