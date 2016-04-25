package com.ktds.leina.article.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.service.ArticleService;
import com.ktds.leina.article.vo.ArticleVO;

@Controller
public class ArticleController {

	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	// page를 보여주면 view~ 로 제목 
	@RequestMapping("/write")
	public ModelAndView viewWrite() {
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
	
	@RequestMapping("/detail/{articleID}")
	public ModelAndView viewDetailpage(@PathVariable String articleID) {
		return articleService.getOneArticle(articleID);
	}
	
	@RequestMapping("/detail/delete/{articleID}") 
	public String deleteOneArticle(@PathVariable String articleID) {
		articleService.deleteOneArticle(articleID);
		return "redirect:/list";
	}
	
	@RequestMapping("/edit/{articleID}")
	public ModelAndView getOneArticleForEdit(@PathVariable String articleID) {
		return articleService.getOneArticleForEdit(articleID);
	}
	
	@RequestMapping("/doEdit") 
	public String editArticle(@Valid ArticleVO articleVO, Errors errors) {
		articleService.editArticle(articleVO);
		return "redirect:/detail/" + articleVO.getArticleID();
	}
}
