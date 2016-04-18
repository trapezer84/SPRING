package com.ktds.leina.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.vo.LoginVO;

@Controller
public class IndexController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index() {
		Integer.parseInt("sdfsdf");
		
		return "mainPage";
		//String으로 리턴되는 것들은 mainPage를 말한다?
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		//WEB-INF/view/login/login.jsp
		
//		if( session.getAttribute("_MEMBER_") == null) {
//			//로그인을 하지 않았을 때의 처리
//			//return "redirect: http://www.daum.net" : 절대 URL 
//			//return "redirect:home" : 상대 URL
//			//return "http://localhost:8080/home"
//			//return "redirect:/home" : 같은 도메인의 절대 URL (상대 URL과의 차이점은 도메인이 있다 없다의 차이)
//			//Redirect 는 reponse.sendRedirect와 같이 대량의 데이터를 보낼 수 없다.  
//			return "redirect:/home";
//		}
		return "login/login";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
//	public String doLogin(HttpServletRequest request) {
//	변수의 명이 파라미터와 같다면 적을 필요 없다. 
//	public String doLogin(@RequestParam("id") String id) {
//	public String doLogin(HttpServletRequest request, @RequestParam String id, @RequestParam String password) {
//	public ModelAndView doLogin(@PathVariable String memberId, @Valid LoginVO loginVO, Errors errors, HttpSession session, HttpServletRequest request) {
	public ModelAndView doLogin(@Valid LoginVO loginVO, Errors errors, HttpSession session, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		//에러가 있느냐 
		if (errors.hasErrors() ) {
			//있을 경우
			view.setViewName("login/login");
			return view;
		}
		
		view.setViewName("redirect:/home");
		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
		
		session.setAttribute("_MEMBER_", loginVO.getId());
		
		System.out.println("ID : " + loginVO.getId());
		System.out.println("Password : " + loginVO.getPassword());
		System.out.println("MemberNumber : " + loginVO.getMemberNumber());
		System.out.println("Enable Auto Login : " + loginVO.isEnableAutoLogin());
		
		for(int i = 0; i <= loginVO.getHobby().size(); i++) {
			System.out.println(loginVO.getHobby().get(i));
		}
		
		return view;
	}
}
