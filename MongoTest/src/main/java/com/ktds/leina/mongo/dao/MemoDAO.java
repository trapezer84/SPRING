package com.ktds.leina.mongo.dao;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.mongo.vo.MemoSearchVO;

public interface MemoDAO {

	public void insertMemo(String memo);
	public void updateMemo(String id, String memo);
	public void removeMemo(String id);
	public ModelAndView getMemoList(MemoSearchVO memoSearchVO);
	public Map getMemo(String id);
	
}
