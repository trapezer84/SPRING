package com.ktds.leina.biz.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.leina.biz.ArticleBiz;
import com.ktds.leina.dao.ArticleDAO;
import com.ktds.leina.vo.EmployeesVO;

public class ArticleBizImpl implements ArticleBiz {

	private Logger logger = LoggerFactory.getLogger(ArticleBizImpl.class);
	
	private ArticleDAO articleDAO;
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public void insertNewArticle() {
		logger.debug("insertNewArticle을 호출했습니다~");
		String nowDate = articleDAO.getNowSystemDate();
		logger.info("현재 시간은 {} 입니다.", nowDate);
	}

	@Override
	public List<EmployeesVO> getAllEmployeeInfo() {
		return articleDAO.getAllEmployeeInfo();
	}
	
	
}
