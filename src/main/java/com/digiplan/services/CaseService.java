package com.digiplan.services;

import com.digiplan.entities.Cases;
import org.json.simple.JSONArray;

import java.util.List;

public interface CaseService {

    List<Cases> getAllCases();

    Cases addCase(Cases casesData);

    JSONArray myCases(String username);
}
