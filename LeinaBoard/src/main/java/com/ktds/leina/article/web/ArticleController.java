package com.ktds.leina.article.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.service.ArticleService;
import com.ktds.leina.article.vo.ArticleVO;

//private ArticlService articleService;

@Controller
public class ArticleController {

	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/write")
	public ModelAndView viewWrite() {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/write");
		return view;
	}
	
	@RequestMapping("/doWrite")
	public ModelAndView doWriteAction(@Valid ArticleVO articleVO, Errors error) {
		return articleService.writeNewArticle(articleVO, error);
	}
	
	@RequestMapping("/list")
	public ModelAndView viewList() {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/list");
		return view;
	}
	
}
