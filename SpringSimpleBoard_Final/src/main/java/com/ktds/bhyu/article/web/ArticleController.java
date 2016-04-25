package com.ktds.bhyu.article.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.bhyu.article.service.ArticleService;
import com.ktds.bhyu.article.vo.ArticleVO;

@Controller
public class ArticleController {
	
	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/write")
	public ModelAndView viewWritePage() { // 페이지를 보여줄 때는 이름을 view???Page 형식으로 해준다.
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
		return articleService.getAllArticleList(pageNo);
	}
	
	@RequestMapping("/detail/{articleId}")
	public ModelAndView viewDetailPage(@PathVariable String articleId) {
		return articleService.getOneArticle(articleId);
	}
	
	@RequestMapping("/doDelete/{articleId}")
	public ModelAndView doDeleteArticle(@PathVariable String articleId) {
		return articleService.doDeleteArticle(articleId);
	}
	
	@RequestMapping("/modify/{articleId}")
	public ModelAndView viewModifyPage(@PathVariable String articleId) {
		return articleService.viewModifyPage(articleId);
	}
	
}
