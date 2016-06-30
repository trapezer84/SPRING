package com.hucloud.di.sample5.biz;

import com.hucloud.di.sample5.dao.DIPracticeDAO;

public class DIPracticeBizImpl implements DIPracticeBiz {

	private DIPracticeDAO diPracticeDAO;
	
	public void setDiPracticeDAO(DIPracticeDAO diPracticeDAO) {
		this.diPracticeDAO = diPracticeDAO;
	}

	@Override
	public String getSomeString() {
		return diPracticeDAO.getSomeString();
	}

}
