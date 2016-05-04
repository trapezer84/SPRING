package com.ktds.leina.service.impl;

import com.ktds.leina.biz.JPABiz;
import com.ktds.leina.service.JPAService;

public class JPAServiceImpl implements JPAService{

	private JPABiz jpaBiz;
	
	public void setJpaBiz(JPABiz jpaBiz) {
		this.jpaBiz = jpaBiz;
	}

	@Override
	public void insertData() {
		jpaBiz.insertData();
	}

}
