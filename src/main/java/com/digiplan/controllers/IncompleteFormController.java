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

import com.digiplan.entities.IncompleteForm;
import com.digiplan.services.IncompleteFormService;

@RestController
public class IncompleteFormController {

    @Autowired
    private IncompleteFormService incompleteFormService;

    @GetMapping("/getIncompleteForm/{id}")
    public ResponseEntity<IncompleteForm> getIncompleteForm(@PathVariable Integer id) {
        IncompleteForm incompleteForm = this.incompleteFormService.getIncompleteForm(id);
        if (incompleteForm != null)
            return new ResponseEntity<IncompleteForm>(incompleteForm, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllIncompleteForms")
    public List<IncompleteForm> getAllIncompleteForms() {
        return this.incompleteFormService.getAllIncompleteForms();
    }

    @PostMapping("/addIncompleteForm")
    public ResponseEntity<IncompleteForm> addIncompleteForm(@RequestBody IncompleteForm incompleteFormData) {
        return new ResponseEntity<IncompleteForm>(this.incompleteFormService.addIncompleteForm(incompleteFormData),
                HttpStatus.CREATED);
    }

    @PutMapping("/updateIncompleteForm/{id}")
    public ResponseEntity<IncompleteForm> updateIncompleteForm(@PathVariable Integer id,
                                                               @RequestBody IncompleteForm incompleteFormData) {
        IncompleteForm incompleteForm = this.incompleteFormService.updateIncompleteForm(id, incompleteFormData);
        if (incompleteForm != null)
            return new ResponseEntity<IncompleteForm>(incompleteForm, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteIncompleteForm/{id}")
    public ResponseEntity<String> deleteIncompleteForm(@PathVariable Integer id) {
        String status = this.incompleteFormService.deleteIncompleteForm(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
