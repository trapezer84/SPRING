package com.ktds.leina.biz.impl;

import com.ktds.leina.biz.JPABiz;
import com.ktds.leina.domain.JPA;
import com.ktds.leina.repository.JPARepository;

public class JPABizImpl implements JPABiz{

	private JPARepository jpaRepository;
	
	public void setJpaRepository(JPARepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public void insertData() {
		JPA jpa = new JPA();
		jpa.setSubject("JPA Test");
		jpa.setDescription("JPA Description");
		
		jpaRepository.save(jpa);
	}

}
