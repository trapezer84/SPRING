package com.ktds.leina.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.biz.ArticleBiz;
import com.ktds.leina.vo.EmployeesVO;

@Controller
public class ArticleController {
	
	// 항상 Logger가 제일 앞에 있어야 한다. 
	// (ArticleController.class); log를 호출하는 class 이름
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	private ArticleBiz articleBiz;
	
	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}

	@RequestMapping("/list")
	public ModelAndView articleList() {
		
		// new 생성자를 applicationContext.xml에 만들어 줘야한다. 
		// property는 setter을 호출하는 것. 이것은 bean과 bean 사이에 있다. 
		articleBiz.insertNewArticle();
		
		logger.trace("안녕하세요. 트레이스 입니다.");
		logger.debug("안녕하세요. 디버그 입니다.");
		logger.info("안녕하세요. 인포 입니다.");
		logger.warn("안녕하세요. 워닝 입니다.");
		logger.error("안녕하세요. 에러 입니다.");
		
		ModelAndView view = new ModelAndView();
		// 어떤 페이지를 보여줄 것인가 : article 밑의 list를 보여줘라
		view.setViewName("article/list");
		
		List<EmployeesVO> allEmloyees = articleBiz.getAllEmployeeInfo();
		view.addObject("allEmployees", allEmloyees);
		
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
