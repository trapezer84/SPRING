package com.hucloud.di.sample4.biz;

import com.hucloud.di.sample4.dao.DIPracticeDAOImpl;

public class DIPracticeBizFactory {

	public static DIPracticeBiz getDIPracticeBiz() {
		DIPracticeBizImpl diPracticeBiz = new DIPracticeBizImpl();
		diPracticeBiz.setDiPracticeDAO(new DIPracticeDAOImpl());
		
		return diPracticeBiz;
	}
	
}
