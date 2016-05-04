package com.ktds.leina.article.biz.impl;

import com.ktds.leina.article.biz.ArticleBiz;
import com.ktds.leina.article.dao.ArticleDAO;
import com.ktds.leina.article.vo.ArticleVO;

public class ArticleBizImpl implements ArticleBiz {

	private ArticleDAO articleDAO;
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public boolean writeNewArticle(ArticleVO articleVO) {
		
		String nowDate = articleDAO.getNowDate();
		int articleNumber = articleDAO.getArticleNumber();
		
		String articleId = "AR-" + nowDate + this.lpad(articleNumber+"", 6, "0"); 
		articleVO.setArticleId(articleId);
		
		return articleDAO.insertNewArticle(articleVO) > 0;
	}

	private String lpad(String source, int length, String deftVale) {
		int sourceLength = source.length();
		int needLength = length - sourceLength;
		
		for(int i = 0; i < needLength; i ++) {
			source = deftVale + source;
		}
		
		return source;
	}

}
