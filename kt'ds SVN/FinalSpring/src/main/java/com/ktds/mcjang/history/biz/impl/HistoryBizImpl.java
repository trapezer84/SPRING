package com.ktds.mcjang.history.biz.impl;

import java.util.List;

import com.ktds.mcjang.history.biz.HistoryBiz;
import com.ktds.mcjang.history.dao.HistoryDAO;
import com.ktds.mcjang.history.vo.HistorySearchVO;
import com.ktds.mcjang.history.vo.HistoryVO;

public class HistoryBizImpl implements HistoryBiz {

	private HistoryDAO historyDAO;
	
	public void setHistoryDAO(HistoryDAO historyDAO) {
		this.historyDAO = historyDAO;
	}

	@Override
	public void putHistory(HistoryVO historyVO) {
		this.historyDAO.putHistory(historyVO);
	}

	@Override
	public List<HistoryVO> getHistoryList(HistorySearchVO searchVO) {
		return this.historyDAO.getHistoryList(searchVO);
	}
	
	@Override
	public int getTotalHistoryCount(HistorySearchVO searchVO) {
		return this.historyDAO.getTotalHistoryCount(searchVO);
	}

}
