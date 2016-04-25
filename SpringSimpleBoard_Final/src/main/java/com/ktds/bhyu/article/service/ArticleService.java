package com.ktds.bhyu.article.service;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.bhyu.article.vo.ArticleVO;

public interface ArticleService {
	
	public ModelAndView writeNewArticle(ArticleVO articleVO, Errors errors);

	public ModelAndView getAllArticleList(int pageNo);

	public ModelAndView getOneArticle(String articleId);

	public ModelAndView doDeleteArticle(String articleId);

	public ModelAndView viewModifyPage(String articleId);
	
	
	
}
