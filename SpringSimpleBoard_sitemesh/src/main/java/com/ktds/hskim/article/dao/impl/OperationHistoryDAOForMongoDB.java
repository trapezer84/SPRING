package com.ktds.hskim.article.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.ktds.hskim.article.dao.OperationHistoryDAO;

public class OperationHistoryDAOForMongoDB implements OperationHistoryDAO{

	private MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void insertHistory(String message) {
		Map<String, Object> historyMap = new HashMap<String, Object>();
		historyMap.put("message", message);
		
		mongoTemplate.insert(historyMap, "operHist");
	}

}
