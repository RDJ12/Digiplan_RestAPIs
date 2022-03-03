package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.TreatmentMethod;

public interface TreatmentMethodService {

	public TreatmentMethod getTreatmentMethodData(String id);

	public List<TreatmentMethod> getAllTreatmentMethodData();

	public TreatmentMethod addTreatmentMethodData(TreatmentMethod treatmentMethodData);

	public TreatmentMethod updateTreatmentMethodData(String id, TreatmentMethod treatmentMethodData);

	public String deleteTreatmentMethodData(String id);

}
