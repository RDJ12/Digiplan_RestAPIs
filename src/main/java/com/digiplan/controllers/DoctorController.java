package com.digiplan.controllers;

import com.digiplan.entities.Doctor;
import com.digiplan.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/getDoctor/{caseId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable String caseId) {
        Doctor doctor = this.doctorService.getDoctor(caseId);
        if (doctor != null)
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        return this.doctorService.getAllDoctors();
    }

    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctorData) {
        return new ResponseEntity<Doctor>(this.doctorService.addDoctor(doctorData), HttpStatus.CREATED);
    }

    @PutMapping("/updateDoctor/{caseId}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String caseId, @RequestBody Doctor doctorData) {
        Doctor doctor = this.doctorService.updateDoctor(caseId, doctorData);
        if (doctor != null)
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteDoctor/{caseId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String caseId) {
        String status = this.doctorService.deleteDoctor(caseId);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
