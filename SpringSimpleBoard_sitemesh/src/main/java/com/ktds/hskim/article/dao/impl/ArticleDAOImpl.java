package com.ktds.hskim.article.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.hskim.article.dao.ArticleDAO;
import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.article.vo.ArticleVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO {

	@Override
	public int nextArtcleSeq() {
		return getSqlSession().selectOne("ArticleDAO.nextArticleSeq");
	}
	
	@Override
	public String nowDate() {
		return getSqlSession().selectOne("ArticleDAO.nowDate");
	}
	
	@Override
	public int insertNewArticle(ArticleVO articleVO) {
		return getSqlSession().insert("ArticleDAO.insertNewArticle", articleVO);
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
	public int deleteArticle(String articleId) {
		return getSqlSession().delete("ArticleDAO.deleteArticle", articleId);
	}

	@Override
	public int updateArticle(ArticleVO articleVO) {
		return getSqlSession().update("ArticleDAO.updateArticle", articleVO);
	}

}
