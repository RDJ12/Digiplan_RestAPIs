package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Draft;

public interface DraftService {

	public Draft getDraft(Integer id);

	public List<Draft> getAllDrafts();

	public Draft addDraft(Draft draftData);

	public Draft updateDraft(Integer id, Draft draftData);

	public String deleteDraft(Integer id);
}
