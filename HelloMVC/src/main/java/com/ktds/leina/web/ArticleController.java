package com.ktds.leina.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {
	
	//(ArticleController.class); log를 호출하는 class 이름
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping("/list")
	public ModelAndView articleList() {
		
		logger.trace("안녕하세요. 트레이스 입니다.");
		logger.debug("안녕하세요. 디버그 입니다.");
		logger.info("안녕하세요. 인포 입니다.");
		logger.warn("안녕하세요. 워닝 입니다.");
		logger.error("안녕하세요. 에러 입니다.");
		
		ModelAndView view = new ModelAndView();
		// 어떤 페이지를 보여줄 것인가 : article 밑의 list를 보여줘라
		view.setViewName("article/list");
		
		view.addObject("title", "제목");
		view.addObject("number", "1");
		view.addObject("author", "홍길동");
		
		return view;
	}
	
	@RequestMapping("/detail/{articleNumber}")
//	public ModelAndView detail(HttpRequest requset) 이렇게 사용할 수도 있지만 바로 파라미터를 받아올 수 있다. 
	public ModelAndView detail(@PathVariable int articleNumber) {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/detail");
		
		view.addObject("articleNumber", articleNumber);
		return view;
	}
	
}
