package com.digiplan.services;

import com.digiplan.entities.Cases;
import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CaseService {

    List<Cases> getAllCases();

    Cases addCase(Cases casesData);

    JSONArray myCases(String username);

    ResponseEntity<Object> downloadReport(String caseId);
}
