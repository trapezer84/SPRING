package com.ktds.leina.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.vo.ArticleVO;

@Controller
public class ArticleController {

	ArticleVO articleNumber = new ArticleVO();

	public ArticleController() {
		articleNumber.setArticleId(0);
	}
	
	/**
	 * 과제 3-1 
	 * HttpServletRequest
	 * @return
	 */
	@RequestMapping(value="/editArticle", method=RequestMethod.GET)
	public String editArticle() {
		return "article/editArticle";
	}
	
	@RequestMapping(value="/showArticle", method=RequestMethod.POST)
	public ModelAndView showArticle(HttpServletRequest request) {
		articleNumber.setArticleId(articleNumber.getArticleId()+1);
		
		ModelAndView view = new ModelAndView();
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		view.setViewName("article/showArticle");
		view.addObject("articleId", articleNumber.getArticleId());
		view.addObject("subject",subject);
		view.addObject("content",content);
		
		return view;
	}
	
	/**
	 * 과제 3-2 
	 * RequestParam
	 * @return
	 */
	@RequestMapping(value="/editArticle2", method=RequestMethod.GET)
	public String editArticle2() {
		return "article/editArticle";
	}
	
	@RequestMapping(value="/showArticle2", method=RequestMethod.POST)
	public ModelAndView showArticle2(@RequestParam String subject, @RequestParam String content) {
		articleNumber.setArticleId(articleNumber.getArticleId()+1);
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("article/showArticle");
		view.addObject("articleId", articleNumber.getArticleId());
		view.addObject("subject",subject);
		view.addObject("content",content);
		
		return view;
	}
	
	/**
	 * 과제 3-3 
	 * RequestParam
	 * @return
	 */
	@RequestMapping(value="/editArticle3", method=RequestMethod.GET)
	public String editArticle3() {
		return "article/editArticle";
	}
	
	@RequestMapping(value="/showArticle3", method=RequestMethod.POST)
	public ModelAndView showArticle2(ArticleVO articleVO) {
		articleNumber.setArticleId(articleNumber.getArticleId()+1);
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("article/showArticle");
		view.addObject("articleId", articleNumber.getArticleId());
		view.addObject("subject", articleVO.getSubject());
		view.addObject("content", articleVO.getContent());
		
		return view;
	}
}
