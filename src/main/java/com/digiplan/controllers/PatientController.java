package com.digiplan.controllers;

import com.digiplan.entities.Patient;
import com.digiplan.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getPatient/{caseId}")
    public ResponseEntity<Patient> getPatient(@PathVariable String caseId) {
        Patient patient = this.patientService.getPatient(caseId);
        if (patient != null)
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {
        return this.patientService.getAllPatients();
    }

    @PostMapping("/addPatient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patientData) {
        return new ResponseEntity<Patient>(this.patientService.addPatient(patientData), HttpStatus.CREATED);
    }

    @PutMapping("/updatePatient/{caseId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String caseId, @RequestBody Patient patientData) {
        Patient patient = this.patientService.updatePatient(caseId, patientData);
        if (patient != null)
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deletePatient/{caseId}")
    public ResponseEntity<String> deletePatient(@PathVariable String caseId) {
        String status = this.patientService.deletePatient(caseId);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
