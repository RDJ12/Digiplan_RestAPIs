package com.digiplan.controllers;

import com.digiplan.entities.Draft;
import com.digiplan.services.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class DraftController {

    @Autowired
    private DraftService draftService;

    @GetMapping("/getDraft/{id}")
    public ResponseEntity<Draft> getDraft(@PathVariable Integer id) {
        Draft draft = this.draftService.getDraft(id);
        if (draft != null)
            return new ResponseEntity<Draft>(draft, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllDrafts")
    public List<Draft> getAllDrafts() {
        return this.draftService.getAllDrafts();
    }

    @PostMapping("/savedraft")
    public ResponseEntity<Draft> addDraft(@RequestBody Draft draftData) {
        return new ResponseEntity<Draft>(this.draftService.addDraft(draftData), HttpStatus.CREATED);
    }

    @PutMapping("/updateDraft/{id}")
    public ResponseEntity<Draft> updateDraft(@PathVariable Integer id, @RequestBody Draft draftData) {
        Draft draft = this.draftService.updateDraft(id, draftData);
        if (draft != null)
            return new ResponseEntity<Draft>(draft, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   /* @DeleteMapping("/deleteDraft/{id}")
    public ResponseEntity<String> deleteDraft(@PathVariable Integer id) {
        String status = this.draftService.deleteDraft(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } */

    @PostMapping("/viewdrafts")
    public ResponseEntity<Map> viewDrafts(@RequestBody Draft draftData) {
        return this.draftService.viewDrafts(draftData);
    }

    @DeleteMapping("/deleteDraft")
    public ResponseEntity<Map> deleteDraft(@RequestParam String draftId) {
        return this.draftService.deleteDraft(draftId);
    }

}
