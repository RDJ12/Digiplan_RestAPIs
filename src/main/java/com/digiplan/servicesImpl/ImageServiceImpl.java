package com.digiplan.servicesImpl;

import com.digiplan.entities.Image;
import com.digiplan.entities.Logger;
import com.digiplan.repositories.ImageRepository;
import com.digiplan.repositories.LoggerRepository;
import com.digiplan.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private LoggerRepository loggerRepository;

    @Override
    public Image getImage(Integer id) {
        Image image = null;
        try {
            Optional<Image> check = imageRepository.findById(id);
            if (check.isPresent())
                image = imageRepository.getById(id);
        } catch (Exception exception) {
            System.out.println("@getImage Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getImage", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return image;
    }

    @Override
    public List<Image> getAllImages() {
        List<Image> imagesList = null;
        try {
            imagesList = imageRepository.findAll();
        } catch (Exception exception) {
            System.out.println("@getAllImages Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getAllImages", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return imagesList;
    }

    @Override
    public Image addImage(Image imageData) {
        Image image = null;
        try {
            image = imageRepository.saveAndFlush(imageData);
        } catch (Exception exception) {
            System.out.println("@addImage Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "addImage", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return image;
    }

    @Override
    public Image updateImage(Integer id, Image imageData) {
        Image image = null;
        try {
            Optional<Image> check = imageRepository.findById(id);
            if (check.isPresent())
                image = imageRepository.saveAndFlush(imageData);
        } catch (Exception exception) {
            System.out.println("@updateImage Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "updateImage", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return image;
    }

    @Override
    public String deleteImage(Integer id) {
        String status = "";
        try {
            imageRepository.deleteById(id);
            status = "Deleted";
        } catch (Exception exception) {
            System.out.println("@deleteImage Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "deleteImage", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return status;
    }

}
