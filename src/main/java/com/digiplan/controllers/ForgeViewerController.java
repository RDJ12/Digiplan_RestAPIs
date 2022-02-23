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

import com.digiplan.entities.ForgeViewer;
import com.digiplan.services.ForgeViewerService;

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
