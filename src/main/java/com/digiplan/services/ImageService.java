package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Image;

public interface ImageService {

    Image getImage(Integer id);

    List<Image> getAllImages();

    Image addImage(Image imageData);

    Image updateImage(Integer id, Image imageData);

    String deleteImage(Integer id);

}
