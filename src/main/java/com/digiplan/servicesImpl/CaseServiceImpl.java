package com.digiplan.servicesImpl;

import com.digiplan.entities.Cases;
import com.digiplan.repositories.CaseRepository;
import com.digiplan.services.CaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public List<Cases> getAllCases() {
        log.info("@Start getAllCases");
        List<Cases> casesList = null;
        try {
            casesList = caseRepository.findAll();
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return casesList;
    }

    @Override
    public Cases addCase(Cases casesData) {
        log.info("@Start addCase");
        Cases cases = null;
        try {
            cases = caseRepository.saveAndFlush(casesData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return cases;
    }
}
