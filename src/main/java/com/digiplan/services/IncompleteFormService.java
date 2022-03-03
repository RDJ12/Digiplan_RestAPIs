package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.IncompleteForm;

public interface IncompleteFormService {

    IncompleteForm getIncompleteForm(Integer id);

    List<IncompleteForm> getAllIncompleteForms();

    IncompleteForm addIncompleteForm(IncompleteForm incompleteFormData);

    IncompleteForm updateIncompleteForm(Integer id, IncompleteForm incompleteFormData);

    String deleteIncompleteForm(Integer id);
}
