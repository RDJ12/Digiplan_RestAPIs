package com.digiplan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digiplan.entities.Diagnosis;
import com.digiplan.services.DiagnosisService;

@RestController
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping("/getDiagnosisData/{id}")
    public ResponseEntity<Diagnosis> getDiagnosisData(@PathVariable String id) {
        Diagnosis diagnosis = this.diagnosisService.getDiagnosisData(id);
        if (diagnosis != null)
            return new ResponseEntity<Diagnosis>(diagnosis, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllDiagnosisData")
    public List<Diagnosis> getAllDiagnosisData() {
        return this.diagnosisService.getAllDiagnosisData();
    }

    @PostMapping("/addDiagnosisData")
    public ResponseEntity<Diagnosis> addDiagnosisData(@RequestBody Diagnosis diagnosisData) {
        return new ResponseEntity<Diagnosis>(this.diagnosisService.addDiagnosisData(diagnosisData), HttpStatus.CREATED);
    }

    @PutMapping("/updateDiagnosisData/{id}")
    public ResponseEntity<Diagnosis> updateDiagnosisData(@PathVariable String id,
                                                         @RequestBody Diagnosis diagnosisData) {
        Diagnosis diagnosis = this.diagnosisService.updateDiagnosisData(id, diagnosisData);
        if (diagnosis != null)
            return new ResponseEntity<Diagnosis>(diagnosis, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteDiagnosisData/{id}")
    public ResponseEntity<String> deleteDiagnosisData(@PathVariable String id) {
        String status = this.diagnosisService.deleteDiagnosisData(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
