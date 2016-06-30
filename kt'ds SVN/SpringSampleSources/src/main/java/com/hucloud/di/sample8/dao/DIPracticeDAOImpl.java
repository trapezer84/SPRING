package com.hucloud.di.sample8.dao;

import org.springframework.stereotype.Component;

@Component
public class DIPracticeDAOImpl implements DIPracticeDAO {

	@Override
	public String getSomeString() {
		return "안녕하세요!";
	}

}
