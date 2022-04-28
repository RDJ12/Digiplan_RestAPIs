package com.digiplan.servicesImpl;

import com.digiplan.entities.IncompleteForm;
import com.digiplan.entities.Logger;
import com.digiplan.repositories.IncompleteFormRepository;
import com.digiplan.repositories.LoggerRepository;
import com.digiplan.services.IncompleteFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IncompleteFormServiceImpl implements IncompleteFormService {

    @Autowired
    private IncompleteFormRepository incompleteFormRepository;

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private LoggerRepository loggerRepository;

    @Override
    public IncompleteForm getIncompleteForm(Integer id) {
        IncompleteForm incompleteForm = null;
        try {
            Optional<IncompleteForm> check = incompleteFormRepository.findById(id);
            if (check.isPresent())
                incompleteForm = incompleteFormRepository.getById(id);
        } catch (Exception exception) {
            System.out.println("@getIncompleteForm Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getIncompleteForm", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return incompleteForm;
    }

    @Override
    public List<IncompleteForm> getAllIncompleteForms() {
        List<IncompleteForm> incompleteFormsList = null;
        try {
            incompleteFormsList = incompleteFormRepository.findAll();
        } catch (Exception exception) {
            System.out.println("@getAllIncompleteForms Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getAllIncompleteForms", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return incompleteFormsList;
    }

    @Override
    public IncompleteForm addIncompleteForm(IncompleteForm incompleteFormData) {
        IncompleteForm incompleteForm = null;
        try {
            incompleteForm = incompleteFormRepository.saveAndFlush(incompleteFormData);
        } catch (Exception exception) {
            System.out.println("@addIncompleteForm Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "addIncompleteForm", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return incompleteForm;
    }

    @Override
    public IncompleteForm updateIncompleteForm(Integer id, IncompleteForm incompleteFormData) {
        IncompleteForm incompleteForm = null;
        try {
            Optional<IncompleteForm> check = incompleteFormRepository.findById(id);
            if (check.isPresent())
                incompleteForm = incompleteFormRepository.saveAndFlush(incompleteFormData);
        } catch (Exception exception) {
            System.out.println("@updateIncompleteForm Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "updateIncompleteForm", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return incompleteForm;
    }

    @Override
    public String deleteIncompleteForm(Integer id) {
        String status = "";
        try {
            incompleteFormRepository.deleteById(id);
            status = "Deleted";
        } catch (Exception exception) {
            System.out.println("@deleteIncompleteForm Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "deleteIncompleteForm", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return status;
    }

}
