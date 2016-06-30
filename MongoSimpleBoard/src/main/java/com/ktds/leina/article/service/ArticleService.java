package com.ktds.leina.article.service;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.vo.ArticleVO;

public interface ArticleService {

	public ModelAndView writeNewArticle(ArticleVO articleVO, Errors errors);

	public ModelAndView getAllArticleList(int pageNo);

	public ModelAndView getOneArticle(String articleID);

	public void deleteOneArticle(String articleID);

	public void editArticle(ArticleVO articleVO);

	public ModelAndView getOneArticleForEdit(String articleID);
	
}
