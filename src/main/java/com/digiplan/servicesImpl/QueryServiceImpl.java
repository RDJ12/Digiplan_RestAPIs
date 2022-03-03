package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Query;
import com.digiplan.repositories.QueryRepository;
import com.digiplan.services.QueryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QueryServiceImpl implements QueryService {

	@Autowired
	private QueryRepository queryRepository;

	@Override
	public Query getQuery(String queryId) {
		log.info("@Start getQuery");
		Query query = null;
		try {
			Optional<Query> check = queryRepository.findById(queryId);
			if (check.isPresent())
				query = queryRepository.getById(queryId);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return query;
	}

	@Override
	public List<Query> getAllQueries() {
		log.info("@Start getAllQueries");
		List<Query> queriesList = null;
		try {
			queriesList = queryRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return queriesList;
	}

	@Override
	public Query addQuery(Query queryData) {
		log.info("@Start addQuery");
		Query query = null;
		try {
			query = queryRepository.saveAndFlush(queryData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return query;
	}

	@Override
	public Query updateQuery(String queryId, Query queryData) {
		log.info("@Start updateQuery");
		Query query = null;
		try {
			Optional<Query> check = queryRepository.findById(queryId);
			if (check.isPresent())
				query = queryRepository.saveAndFlush(queryData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return query;
	}

	@Override
	public String deleteQuery(String queryId) {
		log.info("@Start deletQuery");
		String status = "";
		try {
			queryRepository.deleteById(queryId);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
