package com.ktds.mcjang.history.dao;

import java.util.List;

import com.ktds.mcjang.history.vo.HistorySearchVO;
import com.ktds.mcjang.history.vo.HistoryVO;

public interface HistoryDAO {

	public void putHistory(HistoryVO historyVO);
	public List<HistoryVO> getHistoryList(HistorySearchVO searchVO);
	public int getTotalHistoryCount(HistorySearchVO searchVO);
	
}
