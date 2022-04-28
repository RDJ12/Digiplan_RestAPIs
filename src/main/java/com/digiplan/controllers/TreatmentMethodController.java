package com.digiplan.controllers;

import com.digiplan.entities.TreatmentMethod;
import com.digiplan.services.TreatmentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TreatmentMethodController {

    @Autowired
    private TreatmentMethodService treatmentMethodService;

    @GetMapping("/getTreatmentMethodData/{id}")
    public ResponseEntity<TreatmentMethod> getTreatmentMethodData(@PathVariable String id) {
        TreatmentMethod treatmentMethod = this.treatmentMethodService.getTreatmentMethodData(id);
        if (treatmentMethod != null)
            return new ResponseEntity<TreatmentMethod>(treatmentMethod, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllTreatmentMethodData")
    public List<TreatmentMethod> getAllTreatmentMethodData() {
        return this.treatmentMethodService.getAllTreatmentMethodData();
    }

    @PostMapping("/addTreatmentMethodData")
    public ResponseEntity<TreatmentMethod> addTreatmentMethodData(@RequestBody TreatmentMethod treatmentMethodData) {
        return new ResponseEntity<TreatmentMethod>(
                this.treatmentMethodService.addTreatmentMethodData(treatmentMethodData), HttpStatus.CREATED);
    }

    @PutMapping("/updateTreatmentMethodData/{id}")
    public ResponseEntity<TreatmentMethod> updateTreatmentMethodData(@PathVariable String id,
                                                                     @RequestBody TreatmentMethod treatmentMethodData) {
        TreatmentMethod treatmentMethod = this.treatmentMethodService.updateTreatmentMethodData(id,
                treatmentMethodData);
        if (treatmentMethod != null)
            return new ResponseEntity<TreatmentMethod>(treatmentMethod, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteTreatmentMethodData/{id}")
    public ResponseEntity<String> deleteTreatmentMethodData(@PathVariable String id) {
        String status = this.treatmentMethodService.deleteTreatmentMethodData(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
