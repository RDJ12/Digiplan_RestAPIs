package com.digiplan.servicesImpl;

import com.digiplan.entities.Logger;
import com.digiplan.entities.Query;
import com.digiplan.repositories.LoggerRepository;
import com.digiplan.repositories.QueryRepository;
import com.digiplan.services.QueryService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private LoggerRepository loggerRepository;

    @Override
    public Query getQuery(String queryId) {
        Query query = null;
        try {
            Optional<Query> check = queryRepository.findById(queryId);
            if (check.isPresent())
                query = queryRepository.getById(queryId);
        } catch (Exception exception) {
            System.out.println("@getQuery Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getQuery", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return query;
    }

    @Override
    public List<Query> getAllQueries() {
        List<Query> queriesList = null;
        try {
            queriesList = queryRepository.findAll();
        } catch (Exception exception) {
            System.out.println("@getAllQueries Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "getAllQueries", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return queriesList;
    }

    @Override
    public JSONObject addQuery(Query queryData) {
        JSONObject jsonObject = new JSONObject();
        try {
            queryRepository.saveAndFlush(queryData);
            jsonObject.put("status", 201);
            jsonObject.put("message", "Contact form has been submitted!");
        } catch (Exception exception) {
            System.out.println("@addQuery Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "addQuery", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return jsonObject;
    }

    @Override
    public Query updateQuery(String queryId, Query queryData) {
        Query query = null;
        try {
            Optional<Query> check = queryRepository.findById(queryId);
            if (check.isPresent())
                query = queryRepository.saveAndFlush(queryData);
        } catch (Exception exception) {
            System.out.println("@updateQuery Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "updateQuery", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return query;
    }

    @Override
    public String deleteQuery(String queryId) {
        String status = "";
        try {
            queryRepository.deleteById(queryId);
            status = "Deleted";
        } catch (Exception exception) {
            System.out.println("@deleteQuery Exception : " + exception);
            Logger logger = new Logger(utilityService.getLoggerCorrelationId(), "deleteQuery", exception.getMessage(), exception.toString(), LocalDateTime.now());
            loggerRepository.saveAndFlush(logger);
        }
        return status;
    }

}
