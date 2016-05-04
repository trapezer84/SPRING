package com.ktds.leina.article.service;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.vo.ArticleVO;

public interface ArticleService {

	ModelAndView writeNewArticle(ArticleVO articleVO, Errors error);
}
