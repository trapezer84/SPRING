package com.ktds.hskim.article.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.hskim.CustomLogger;
import com.ktds.hskim.MongoLogger;
import com.ktds.hskim.article.service.ArticleService;
import com.ktds.hskim.article.vo.ArticleVO;

@Controller
public class ArticleController {
	
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	private CustomLogger clogger = new MongoLogger(logger, "mongoTemplate");
	
	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/write")
	public ModelAndView viewWritePage() {
		clogger.info("wirte 페이지에 접근했습니다.");
		ModelAndView view = new ModelAndView();
		view.setViewName("article/write");
		
		return view;
	}
	
	@RequestMapping("/doWriteAction")
	public ModelAndView doWriteAction(@Valid ArticleVO articleVO, Errors errors) {
		return articleService.writeNewArticle(articleVO, errors);
	}
	
	@RequestMapping("/list")
	public ModelAndView viewListPage(@RequestParam(required=false, defaultValue="0") int pageNo) {
		clogger.info("list 페이지에 접근했습니다.");
		return articleService.getAllArticleList(pageNo);
	}
	
	@RequestMapping("/detail/{articleId}")
	public ModelAndView viewDetailPage(@PathVariable String articleId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/detail");
		view.addObject("article", articleService.getOneArticle(articleId));
		
		return view;
	}
	
	@RequestMapping("/delete/{articleId}")
	public ModelAndView doDelete(@PathVariable String articleId) {
		return articleService.deleteArticle(articleId);
	}
	
	@RequestMapping("/modify/{articleId}")
	public ModelAndView doModify(@PathVariable String articleId) {
		return articleService.modifyArticle(articleId);
	}
	
}
