package com.digiplan.services;

import com.digiplan.entities.Draft;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DraftService {

    Draft getDraft(Integer id);

    List<Draft> getAllDrafts();

    Draft addDraft(Draft draftData);

    Draft updateDraft(Integer id, Draft draftData);

    //String deleteDraft(Integer id);

    JSONObject viewDrafts(Draft draftData);

    ResponseEntity<Map> deleteDraft(String draftId);
}
