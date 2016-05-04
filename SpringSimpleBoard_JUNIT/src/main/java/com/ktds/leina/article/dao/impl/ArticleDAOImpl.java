package com.ktds.leina.article.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.dao.ArticleDAO;
import com.ktds.leina.article.vo.ArticleSearchVO;
import com.ktds.leina.article.vo.ArticleVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO{

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
	public ArticleVO getOneArticle(String articleID) {
		return getSqlSession().selectOne("ArticleDAO.getOneArticle", articleID);
	}

	@Override
	public void deleteOneArticle(String articleID) {
		getSqlSession().delete("ArticleDAO.deleteOneArticle", articleID);
	}

	@Override
	public void editArticle(ArticleVO newArticleVO) {
		getSqlSession().update("ArticleDAO.editArticle", newArticleVO);
	}

}
