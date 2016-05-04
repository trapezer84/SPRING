package com.ktds.leina.article.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.leina.article.dao.ArticleDAO;
import com.ktds.leina.article.vo.ArticleVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO {

	@Override
	public int insertNewArticle(ArticleVO articleVO) {
		return getSqlSession().insert("ArticleDAO.insertNewArticle", articleVO);
	}

	@Override
	public String getNowDate() {
		return getSqlSession().selectOne("ArticleDAO.getNowDate");
	}

	@Override
	public int getArticleNumber() {
		return getSqlSession().selectOne("ArticleDAO.getArticleNumber");
	}

}
