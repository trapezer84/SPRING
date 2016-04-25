package com.ktds.bhyu.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.ktds.bhyu")
public class CustomExceptionHandler {
	
	@ExceptionHandler({RuntimeException.class}) // RuntimeException : 왠만한 모든 예외를 처리함
	public ModelAndView runtimeExceptionHandler(RuntimeException re, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("error/500");
		view.addObject("message", re.getMessage());
		
		String referer = request.getHeader("Referer");
		view.addObject("from", referer);
		
		view.addObject("content", "내가 보냄...");
		
		return view;
	}
	
}
