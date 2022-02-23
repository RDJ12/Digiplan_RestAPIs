package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.IncompleteForm;

public interface IncompleteFormService {

	public IncompleteForm getIncompleteForm(Integer id);

	public List<IncompleteForm> getAllIncompleteForms();

	public IncompleteForm addIncompleteForm(IncompleteForm incompleteFormData);

	public IncompleteForm updateIncompleteForm(Integer id, IncompleteForm incompleteFormData);

	public String deleteIncompleteForm(Integer id);
}
