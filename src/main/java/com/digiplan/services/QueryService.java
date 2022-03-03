package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Query;

public interface QueryService {

    Query getQuery(String queryId);

    List<Query> getAllQueries();

    Query addQuery(Query queryData);

    Query updateQuery(String queryId, Query queryData);

    String deleteQuery(String queryId);

}
