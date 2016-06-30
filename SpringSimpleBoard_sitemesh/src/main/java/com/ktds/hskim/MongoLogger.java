package com.ktds.hskim;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MongoLogger extends CustomLogger {
	
	private MongoTemplate mongoTemplate;
	
	private MongoLogger(Logger logger) {
		super(logger);
	}
	
	public MongoLogger(Logger logger, MongoTemplate mongoTemplate) {
		super(logger);
		this.mongoTemplate = mongoTemplate;
	}
	
	// mongoTemplate을 가져올 수 없을 때, spring bean을 직접 가져와서 사용하는 방법 
	public MongoLogger(Logger logger, String mongoTemplateBeanName) {
		super(logger);
//		setMongoTemplate(mongoTemplateBeanName);
		setMongoTemplateFromXML(mongoTemplateBeanName);
	}
	
	// spring bean 가져오는 방법 
	private void setMongoTemplate(String mongoTemplateBeanName) {
		// 아예 spring에 설치된 request 받아오는 방법
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		
		WebApplicationContext webContext = WebApplicationContextUtils.getWebApplicationContext(context);
		
		// 몽고 컨텍스트에 있는 bean을 가져오는 방법
		this.mongoTemplate = (MongoTemplate) webContext.getBean(mongoTemplateBeanName);
	}
	
	private void setMongoTemplateFromXML(String mongoTemplateBeanName) {
		String mongoContext = "/mongoContextForLogger.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContext);
		
		this.mongoTemplate = (MongoTemplate) ctx.getBean(mongoTemplateBeanName);
	}
	
	@Override
	protected void writeTrace(String msg) {
		// 1. Level : Trace, Debug, Info, Warm, Error
		// 2. 시간 : 언제 찍히나
		// 3. 요청자 : 누가 찍었나
		// 4. 로그 메세지 : 무엇을 찍었나
		
		Map log = new HashMap<String, Object>();
		log.put("LEVEL", "TRACE");
		log.put("DATETIME", new Date()); // util Date() import 
		log.put("REQUESTER", logger.getName());
		log.put("MESSAGE", msg);
		
		mongoTemplate.insert(log, "log");
	}

	@Override
	protected void writeDebug(String msg) {
		Map log = new HashMap<String, Object>();
		log.put("LEVEL", "DEBUG");
		log.put("DATETIME", new Date()); // util Date() import 
		log.put("REQUESTER", logger.getName());
		log.put("MESSAGE", msg);
		
		mongoTemplate.insert(log, "log");
	}

	@Override
	protected void writeInfo(String msg) {
		Map log = new HashMap<String, Object>();
		log.put("LEVEL", "INFO");
		log.put("DATETIME", new Date()); // util Date() import 
		log.put("REQUESTER", logger.getName());
		log.put("MESSAGE", msg);
		
		mongoTemplate.insert(log, "log");
	}

	@Override
	protected void writeWarm(String msg) {
		Map log = new HashMap<String, Object>();
		log.put("LEVEL", "WARM");
		log.put("DATETIME", new Date()); // util Date() import 
		log.put("REQUESTER", logger.getName());
		log.put("MESSAGE", msg);
		
		mongoTemplate.insert(log, "log");
	}

	@Override
	protected void writeError(String msg) {
		Map log = new HashMap<String, Object>();
		log.put("LEVEL", "ERROR");
		log.put("DATETIME", new Date()); // util Date() import 
		log.put("REQUESTER", logger.getName());
		log.put("MESSAGE", msg);
		
		mongoTemplate.insert(log, "log");
	}
	
}
