package com.ktds.mcjang.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.board.dao.BoardDAO;
import com.ktds.mcjang.board.vo.ArticleSearchVO;
import com.ktds.mcjang.board.vo.ArticleVO;

public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {

	@Override
	public void write(ArticleVO articleVO) {
		getSqlSession().insert("boardDAO.write", articleVO);
	}

	@Override
	public ArticleVO getArticle(int id) {
		return getSqlSession().selectOne("boardDAO.getArticle", id);
	}

	@Override
	public int getArticleCount(ArticleSearchVO articleSearchVO) {
		return getSqlSession().
				selectOne("boardDAO.getArticleCount", articleSearchVO);
	}
	
	@Override
	public List<ArticleVO> getList(ArticleSearchVO articleSearchVO) {
		return getSqlSession().
				selectList("boardDAO.getList", articleSearchVO);
	}

	@Override
	public void modify(ArticleVO articleVO) {
		getSqlSession().update("boardDAO.modify", articleVO);
	}

	@Override
	public void delete(ArticleVO articleVO) {
		getSqlSession().delete("boardDAO.delete", articleVO);
	}

	@Override
	public void updateHitCount(String id) {
		String message = String.format("%s 조회수 1증가합니다. ", id);
		System.out.println(message);
	}

	@Override
	public void updateRecommendCount(String id) {
		String message = String.format("%s 추천수 1증가합니다. ", id);
		System.out.println(message);
	}

}
