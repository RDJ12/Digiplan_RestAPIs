package com.digiplan.services;

import com.digiplan.entities.Query;
import org.json.simple.JSONObject;

import java.util.List;

public interface QueryService {

    Query getQuery(String queryId);

    List<Query> getAllQueries();

    JSONObject addQuery(Query queryData);

    Query updateQuery(String queryId, Query queryData);

    String deleteQuery(String queryId);

}
