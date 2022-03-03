package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Dealer;
import com.digiplan.repositories.DealerRepository;
import com.digiplan.services.DealerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    @Override
    public Dealer getDealer(Integer id) {
        log.info("@Start getDealer");
        Dealer dealer = null;
        try {
            Optional<Dealer> check = dealerRepository.findById(id);
            if (check.isPresent())
                dealer = dealerRepository.getById(id);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return dealer;
    }

    @Override
    public List<Dealer> getAllDealers() {
        log.info("@Start getAllDealers");
        List<Dealer> dealersList = null;
        try {
            dealersList = dealerRepository.findAll();
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return dealersList;
    }

    @Override
    public Dealer addDealer(Dealer dealerData) {
        log.info("@Start addDealer");
        Dealer dealer = null;
        try {
            dealer = dealerRepository.saveAndFlush(dealerData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return dealer;
    }

    @Override
    public Dealer updateDealer(Integer id, Dealer dealerData) {
        log.info("@Start updateDealer");
        Dealer dealer = null;
        try {
            Optional<Dealer> check = dealerRepository.findById(id);
            if (check.isPresent())
                dealer = dealerRepository.saveAndFlush(dealerData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return dealer;
    }

    @Override
    public String deleteDealer(Integer id) {
        log.info("@Start deleteDealer");
        String status = "";
        try {
            dealerRepository.deleteById(id);
            status = "Deleted";
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return status;
    }

}
