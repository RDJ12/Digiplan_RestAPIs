package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Dealer;

public interface DealerService {

	public Dealer getDealer(Integer id);

	public List<Dealer> getAllDealers();

	public Dealer addDealer(Dealer dealerData);

	public Dealer updateDealer(Integer id, Dealer dealerData);

	public String deleteDealer(Integer id);
}
