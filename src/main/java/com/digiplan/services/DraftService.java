package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Draft;

public interface DraftService {

    Draft getDraft(Integer id);

    List<Draft> getAllDrafts();

    Draft addDraft(Draft draftData);

    Draft updateDraft(Integer id, Draft draftData);

    String deleteDraft(Integer id);

    List<Draft> viewDrafts(Draft draftData);
}
