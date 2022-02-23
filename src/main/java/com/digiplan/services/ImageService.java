package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Image;

public interface ImageService {

	public Image getImage(Integer id);

	public List<Image> getAllImages();

	public Image addImage(Image imageData);

	public Image updateImage(Integer id, Image imageData);

	public String deleteImage(Integer id);

}
