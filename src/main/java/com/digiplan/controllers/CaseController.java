package com.digiplan.controllers;

import com.digiplan.entities.Cases;
import com.digiplan.entities.User;
import com.digiplan.services.CaseService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping("/getAllCases")
    public List<Cases> getAllCases() {
        return this.caseService.getAllCases();
    }

    @PostMapping("/savecase")
    public ResponseEntity<Cases> addCase(@RequestBody Cases casesData) {
        return new ResponseEntity<Cases>(this.caseService.addCase(casesData), HttpStatus.CREATED);
    }

    @PostMapping("/mycase")
    public JSONArray myCases(@RequestBody User userData) {
        return this.caseService.myCases(userData.getUsername());
    }

    @GetMapping("/users/{caseId}/Report.pdf")
    public ResponseEntity<Object> downloadReport(@PathVariable String caseId) {
        return this.caseService.downloadReport(caseId);
    }

}
