package com.digiplan.controllers;

import com.digiplan.entities.Cases;
import com.digiplan.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
