package com.ktds.mcjang.history.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.history.dao.HistoryDAO;
import com.ktds.mcjang.history.vo.HistorySearchVO;
import com.ktds.mcjang.history.vo.HistoryVO;

public class HistoryDAOImpl extends SqlSessionDaoSupport implements HistoryDAO {

	@Override
	public void putHistory(HistoryVO historyVO) {
		getSqlSession().insert("historyDAO.putHistory", historyVO);
	}

	@Override
	public List<HistoryVO> getHistoryList(HistorySearchVO searchVO) {
		return getSqlSession().selectList("historyDAO.getHistoryList", searchVO);
	}
	
	@Override
	public int getTotalHistoryCount(HistorySearchVO searchVO) {
		return getSqlSession().
				selectOne(
						"historyDAO.getTotalHistoryCount"
						, searchVO);
	}

}
