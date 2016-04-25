package com.ktds.leina.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//com.ktds.leina 이하의 package에서 발생되는 에러들을 모두 보겠다. 라는 의미! 
@ControllerAdvice("com.ktds.leina")
public class CustomExceptionHandler {

	//에러가 발생되면 여기를 거쳐서 output된다!
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeExceptionHandler(RuntimeException re, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("error/500.jsp");
		view.addObject("contents", "기연이 보냄...");
		view.addObject("message", re.getMessage());
		String referer = request.getHeader("Referer");
		view.addObject("from", referer);
		return view;
	}
}
