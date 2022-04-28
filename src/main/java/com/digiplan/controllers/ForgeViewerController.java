package com.digiplan.controllers;

import com.digiplan.entities.ForgeViewer;
import com.digiplan.services.ForgeViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ForgeViewerController {

    @Autowired
    private ForgeViewerService forgeViewerService;

    @GetMapping("/getForgeViewer/{id}")
    public ResponseEntity<ForgeViewer> getForgeViewer(@PathVariable Integer id) {
        ForgeViewer forgeViewer = this.forgeViewerService.getForgeViewer(id);
        if (forgeViewer != null)
            return new ResponseEntity<ForgeViewer>(forgeViewer, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllForgeViewers")
    public List<ForgeViewer> getAllForgeViewers() {
        return this.forgeViewerService.getAllForgeViewers();
    }

    @PostMapping("/addForgeViewer")
    public ResponseEntity<ForgeViewer> addForgeViewer(@RequestBody ForgeViewer forgeViewerData) {
        return new ResponseEntity<ForgeViewer>(this.forgeViewerService.addForgeViewer(forgeViewerData),
                HttpStatus.CREATED);
    }

    @PutMapping("/updateForgeViewer/{id}")
    public ResponseEntity<ForgeViewer> updateForgeViewer(@PathVariable Integer id,
                                                         @RequestBody ForgeViewer forgeViewerData) {
        ForgeViewer forgeViewer = this.forgeViewerService.updateForgeViewer(id, forgeViewerData);
        if (forgeViewer != null)
            return new ResponseEntity<ForgeViewer>(forgeViewer, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteForgeViewer/{id}")
    public ResponseEntity<String> deleteForgeViewer(@PathVariable Integer id) {
        String status = this.forgeViewerService.deleteForgeViewer(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
