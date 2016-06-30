package com.ktds.mcjang.history.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.common.util.Paging;
import com.ktds.mcjang.history.biz.HistoryBiz;
import com.ktds.mcjang.history.service.HistoryService;
import com.ktds.mcjang.history.vo.HistorySearchVO;
import com.ktds.mcjang.history.vo.HistoryVO;

public class HistoryServiceImpl implements HistoryService {

	private HistoryBiz historyBiz;
	
	public void setHistoryBiz(HistoryBiz historyBiz) {
		this.historyBiz = historyBiz;
	}

	@Override
	public ModelAndView getHistoryList(HttpServletRequest request) {
		
		String pageNumber = request.getParameter("pageNo");
		Paging paging = new Paging();
		paging.setPageNumber(pageNumber);
		
		HistorySearchVO searchVO = new HistorySearchVO();
		searchVO.setStartNumber(paging.getStartArticleNumber());
		searchVO.setEndNumber(paging.getEndArticleNumber());
		
		int totalHistoryCount = 
				this.historyBiz.getTotalHistoryCount(searchVO);
		
		paging.setTotalArticleCount(totalHistoryCount);
		
		List<HistoryVO> historyList = null;
		if(totalHistoryCount > 0) {
			historyList = 
					this.historyBiz.getHistoryList(searchVO);
		}
		
		ModelAndView view = new ModelAndView();
		view.addObject("historyList", historyList);
		view.addObject("totalCount", paging.getTotalCount());
		view.addObject("paging", paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", ""));
		view.setViewName("admin/viewOperationHistoryList");
		return view; 
	}

}
