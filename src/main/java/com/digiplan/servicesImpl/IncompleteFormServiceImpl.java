package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.IncompleteForm;
import com.digiplan.repositories.IncompleteFormRepository;
import com.digiplan.services.IncompleteFormService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IncompleteFormServiceImpl implements IncompleteFormService {

    @Autowired
    private IncompleteFormRepository incompleteFormRepository;

    @Override
    public IncompleteForm getIncompleteForm(Integer id) {
        log.info("@Start getIncompleteForm");
        IncompleteForm incompleteForm = null;
        try {
            Optional<IncompleteForm> check = incompleteFormRepository.findById(id);
            if (check.isPresent())
                incompleteForm = incompleteFormRepository.getById(id);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return incompleteForm;
    }

    @Override
    public List<IncompleteForm> getAllIncompleteForms() {
        log.info("@Start getAllIncompleteForms");
        List<IncompleteForm> incompleteFormsList = null;
        try {
            incompleteFormsList = incompleteFormRepository.findAll();
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return incompleteFormsList;
    }

    @Override
    public IncompleteForm addIncompleteForm(IncompleteForm incompleteFormData) {
        log.info("@Start addIncompleteForm");
        IncompleteForm incompleteForm = null;
        try {
            incompleteForm = incompleteFormRepository.saveAndFlush(incompleteFormData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return incompleteForm;
    }

    @Override
    public IncompleteForm updateIncompleteForm(Integer id, IncompleteForm incompleteFormData) {
        log.info("@Start updateIncompleteForm");
        IncompleteForm incompleteForm = null;
        try {
            Optional<IncompleteForm> check = incompleteFormRepository.findById(id);
            if (check.isPresent())
                incompleteForm = incompleteFormRepository.saveAndFlush(incompleteFormData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return incompleteForm;
    }

    @Override
    public String deleteIncompleteForm(Integer id) {
        log.info("@Start deleteIncompleteForm");
        String status = "";
        try {
            incompleteFormRepository.deleteById(id);
            status = "Deleted";
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return status;
    }

}
