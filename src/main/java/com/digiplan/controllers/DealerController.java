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

import com.digiplan.entities.Dealer;
import com.digiplan.services.DealerService;

@RestController
public class DealerController {

	@Autowired
	private DealerService dealerService;

	@GetMapping("/getDealer/{id}")
	public ResponseEntity<Dealer> getDealer(@PathVariable Integer id) {
		Dealer dealer = this.dealerService.getDealer(id);
		if (dealer != null)
			return new ResponseEntity<Dealer>(dealer, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllDealers")
	public List<Dealer> getAllDealers() {
		return this.dealerService.getAllDealers();
	}

	@PostMapping("/addDealer")
	public ResponseEntity<Dealer> addDraft(@RequestBody Dealer dealerData) {
		return new ResponseEntity<Dealer>(this.dealerService.addDealer(dealerData), HttpStatus.CREATED);
	}

	@PutMapping("/updateDealer/{id}")
	public ResponseEntity<Dealer> updateDealer(@PathVariable Integer id, @RequestBody Dealer dealerData) {
		Dealer dealer = this.dealerService.updateDealer(id, dealerData);
		if (dealer != null)
			return new ResponseEntity<Dealer>(dealer, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteDealer/{id}")
	public ResponseEntity<String> deleteDealer(@PathVariable Integer id) {
		String status = this.dealerService.deleteDealer(id);
		if (status.equals("Deleted"))
			return new ResponseEntity<String>(status, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
