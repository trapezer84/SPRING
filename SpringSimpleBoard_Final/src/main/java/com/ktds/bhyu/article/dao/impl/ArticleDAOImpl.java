package com.ktds.bhyu.article.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.bhyu.article.dao.ArticleDAO;
import com.ktds.bhyu.article.vo.ArticleSearchVO;
import com.ktds.bhyu.article.vo.ArticleVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO {

	@Override
	public int insertNewArticle(ArticleVO articleVO) {
		return getSqlSession().insert("ArticleDAO.insertNewArticle", articleVO);
	}

	@Override
	public int nextArticleSeq() {
		return getSqlSession().selectOne("ArticleDAO.nextArticleSeq");
	}

	@Override
	public String nowDate() {
		return getSqlSession().selectOne("ArticleDAO.nowDate");
	}

	@Override
	public int getTotalArticleCount() {
		return getSqlSession().selectOne("ArticleDAO.getTotalArticleCount");
	}

	@Override
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO) {
		return getSqlSession().selectList("ArticleDAO.getAllArticle", searchVO);
	}

	@Override
	public ArticleVO getOneArticle(String articleId) {
		return getSqlSession().selectOne("ArticleDAO.getOneArticle", articleId);
	}

	@Override
	public int doDeleteArticle(String articleId) {
		return getSqlSession().delete("ArticleDAO.doDeleteArticle", articleId);
	}

	@Override
	public int doModifyArticle(ArticleVO articleVO) {
		return getSqlSession().update("ArticleDAO.doModifyArticle", articleVO);
	}

}
