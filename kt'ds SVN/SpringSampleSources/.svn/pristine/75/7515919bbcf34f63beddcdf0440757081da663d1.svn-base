package com.hucloud.di.sample3.biz;

import com.hucloud.di.sample3.dao.DIPracticeDAO;
import com.hucloud.di.sample3.dao.DIPracticeDAOImpl;

public class DIPracticeBizImpl implements DIPracticeBiz {

	private DIPracticeDAO diPracticeDAO;
	
	public DIPracticeBizImpl() {
		diPracticeDAO = new DIPracticeDAOImpl();
	}
	
	@Override
	public String getSomeString() {
		return diPracticeDAO.getSomeString();
	}

}
