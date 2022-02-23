package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Query;

public interface QueryService {

	public Query getQuery(String queryId);

	public List<Query> getAllQueries();

	public Query addQuery(Query queryData);

	public Query updateQuery(String queryId, Query queryData);

	public String deleteQuery(String queryId);

}
