package com.hucloud.di.sample2.biz;

import com.hucloud.di.sample2.dao.DIPracticeDAO;
import com.hucloud.di.sample2.dao.DIPracticeDAOImpl;

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
