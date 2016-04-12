package com.ktds.leina.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.vo.LoginVO;

@Controller
public class IndexController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index() {
		return "mainPage";
		//String으로 리턴되는 것들은 mainPage를 말한다?
	}
	
	
	/**
	 * 과제 1-1 번  
	 * HttpServletRequest
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login/login";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		view.setViewName("login/doLogin");
		view.addObject("id", id);
		view.addObject("password", password);
		
		return view;
	}
	
	/**
	 * 과제 1-2 번 
	 * RequestParam
	 * @return
	 */
	@RequestMapping(value="/login2", method=RequestMethod.GET)
	public String login2(){
		return "login/login2";
	}
	
	@RequestMapping(value="/doLogin2", method=RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam String id, @RequestParam String password) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("login/doLogin2");
		view.addObject("id", id);
		view.addObject("password", password);
		
		return view;
	}
	
	/**
	 * 과제 1-3 번 
	 * Command
	 * @return
	 */
	@RequestMapping(value="/login3", method=RequestMethod.GET)
	public String login3(){
		return "login/login3";
	}
	
	@RequestMapping(value="/doLogin3", method=RequestMethod.POST)
	public ModelAndView doLogin(LoginVO loginVO) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("login/doLogin3");
		view.addObject("id", loginVO.getId());
		view.addObject("password", loginVO.getPassword());
		
		return view;
	}
}
