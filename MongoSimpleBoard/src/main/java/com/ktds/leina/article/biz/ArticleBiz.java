package com.ktds.leina.article.biz;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.vo.ArticleSearchVO;
import com.ktds.leina.article.vo.ArticleVO;

public interface ArticleBiz {

	public boolean writeNewArticle(ArticleVO articleVO);

	public int getTotalArticleCount();

	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO);

	public ArticleVO getOneArticle(String articleID);

	public void deleteOneArticle(String articleID);

	public void editArticle(ArticleVO newArticleVO);
	
	
}
