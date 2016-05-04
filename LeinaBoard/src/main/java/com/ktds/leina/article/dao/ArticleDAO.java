package com.ktds.leina.article.dao;

import com.ktds.leina.article.vo.ArticleVO;

public interface ArticleDAO {

	public int insertNewArticle(ArticleVO articleVO);
	public String getNowDate();
	public int getArticleNumber();

}
