package com.hucloud.di.sample1.biz;

import com.hucloud.di.sample1.dao.DIPracticeDAO;

public class DIPracticeBiz {

	private DIPracticeDAO diPracticeDAO;
	
	public DIPracticeBiz() {
		diPracticeDAO = new DIPracticeDAO();
	}
	
	public String getSomeString() {
		return diPracticeDAO.getSomeString();
	}
	
}
