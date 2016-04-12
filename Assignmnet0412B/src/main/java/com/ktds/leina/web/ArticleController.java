package com.ktds.leina.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

	@RequestMapping("/article/{articleNumber}")
	public ModelAndView articleList(@PathVariable int articleNumber) {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/article");
	
		view.addObject("articleNumber", articleNumber);
		return view;
	}
}
