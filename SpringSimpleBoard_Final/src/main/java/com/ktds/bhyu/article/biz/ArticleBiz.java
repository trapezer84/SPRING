package com.ktds.bhyu.article.biz;

import java.util.List;

import com.ktds.bhyu.article.vo.ArticleSearchVO;
import com.ktds.bhyu.article.vo.ArticleVO;

public interface ArticleBiz {
	
	public boolean writeNewArticle(ArticleVO articleVO);

	public int getTotalArticleCount();

	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO);

	public ArticleVO getOneArticle(String articleId);

	public boolean doDeleteArticle(String articleId);

	public boolean doModifyArticle(ArticleVO articleVO);
	
}
