package com.hucloud.di.sample6.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hucloud.di.sample6.dao.DIPracticeDAO;

@Component("diPracticeBiz")
public class DIPracticeBizImpl implements DIPracticeBiz {

	@Autowired
	private DIPracticeDAO diPracticeDAO;
	
	@Override
	public String getSomeString() {
		return diPracticeDAO.getSomeString();
	}

}
