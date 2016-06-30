package com.ktds.mcjang.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.login.service.LoginService;
import com.ktds.mcjang.login.vo.UsersVO;

@Controller
public class LoginController {

	private LoginService loginService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/login")
	public ModelAndView loignView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("login/login");
		return view;
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public ModelAndView doLogin(@Valid UsersVO usersVO
			, Errors errors, HttpServletRequest request) {
		return this.loginService.login(usersVO, errors, request);
	}
	
}








