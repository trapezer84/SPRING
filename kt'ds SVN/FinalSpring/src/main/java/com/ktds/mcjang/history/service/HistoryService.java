package com.ktds.mcjang.history.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface HistoryService {

	public ModelAndView getHistoryList(HttpServletRequest request);
	
}
