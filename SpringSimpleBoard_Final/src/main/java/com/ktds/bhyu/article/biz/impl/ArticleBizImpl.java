package com.ktds.bhyu.article.biz.impl;

import java.util.List;

import com.ktds.bhyu.article.biz.ArticleBiz;
import com.ktds.bhyu.article.dao.ArticleDAO;
import com.ktds.bhyu.article.vo.ArticleSearchVO;
import com.ktds.bhyu.article.vo.ArticleVO;

public class ArticleBizImpl implements ArticleBiz {

	private ArticleDAO articleDAO;
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public boolean writeNewArticle(ArticleVO articleVO) {
//		throw new NotImplementedException(); // 아직 구현되지 않은 메소드일 때 리턴을 exception으로 던진다
		
		int nextArticleId = articleDAO.nextArticleSeq();
		String nowDate = articleDAO.nowDate();
		
		/*
		 * ArticleID의 형식
		 * AR-20160421-000001
		 */
		
		String articleId = "AR-" + nowDate + "-" + lpad(nextArticleId + "", 6, "0");
		
		articleVO.setArticleNumber(nextArticleId);
		articleVO.setArticleId(articleId);
		
		return articleDAO.insertNewArticle(articleVO) > 0;
	}

	/**
	 * 
	 * @param source 원본
	 * @param length 만들어져야 하는 길이
	 * @param defValue 채워질 글자
	 * @return
	 */
	private String lpad(String source, int length, String defValue) {
		int sourceLength = source.length();
		int needLength = length - sourceLength;
		
		for (int i = 0; i < needLength; i++) {
			source = defValue + source;
		}
		return source;
	}

	@Override
	public int getTotalArticleCount() {
		return articleDAO.getTotalArticleCount();
	}

	@Override
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO) {
		return articleDAO.getAllArticle(searchVO);
	}

	@Override
	public ArticleVO getOneArticle(String articleId) {
		return articleDAO.getOneArticle(articleId);
	}

	@Override
	public boolean doDeleteArticle(String articleId) {
		return articleDAO.doDeleteArticle(articleId) > 0;
	}

	@Override
	public boolean doModifyArticle(ArticleVO articleVO) {
		
		ArticleVO originArticleVO = getOneArticle(articleVO.getArticleId());
		ArticleVO checkArticleVO = new ArticleVO();
		checkArticleVO.setArticleId(articleVO.getArticleId());
		
		if ( !originArticleVO.getSubject().equals(articleVO.getSubject()) ) {
			checkArticleVO.setSubject(articleVO.getSubject());
		}
		if ( !originArticleVO.getWriter().equals(articleVO.getWriter()) ) {
			checkArticleVO.setWriter(articleVO.getWriter());
		}
		if ( !originArticleVO.getDescription().equals(articleVO.getDescription()) ) {
			checkArticleVO.setDescription(articleVO.getDescription());
		}
		
		return articleDAO.doModifyArticle(checkArticleVO) > 0;
	}
	
}
