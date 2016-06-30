package com.ktds.mcjang.history.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.history.service.HistoryService;

@Controller
public class HistoryController {

	private HistoryService historyService;

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	
	@RequestMapping("/admin/viewOperationHistory")
	public ModelAndView viewHistoryList(
			HttpServletRequest request) {
		
		return this.historyService.getHistoryList(request);
	}
	
	
}
