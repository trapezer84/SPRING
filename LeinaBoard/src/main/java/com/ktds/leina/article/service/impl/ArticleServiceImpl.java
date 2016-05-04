package com.ktds.leina.article.service.impl;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.biz.ArticleBiz;
import com.ktds.leina.article.service.ArticleService;
import com.ktds.leina.article.vo.ArticleVO;

public class ArticleServiceImpl implements ArticleService {

	private ArticleBiz articleBiz;
	
	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}

	@Override
	public ModelAndView writeNewArticle(ArticleVO articleVO, Errors error) {
		ModelAndView view = new ModelAndView();
		
		
		if (error.hasErrors()) {
			view.addObject(articleVO);
			view.setViewName("article/write");
			
			return view;
		}
		else {
			boolean result = articleBiz.writeNewArticle(articleVO);
			if (result) {
				view.setViewName("redirect:/list");
			} 
			else {
				throw new RuntimeException("장애가 발생하였습니다.");
			}
			
			return view;
		}
		
	}

}
