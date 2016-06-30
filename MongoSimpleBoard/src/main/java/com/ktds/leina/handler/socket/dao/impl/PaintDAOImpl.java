package com.ktds.leina.handler.socket.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.leina.handler.socket.dao.PaintDAO;

public class PaintDAOImpl extends SqlSessionDaoSupport implements PaintDAO{

	@Override
	public String getAnswer() {
		return getSqlSession().selectOne("PaintDAO.getAnswer");
	}

	@Override
	public void inserAnswer(String answer) {
		getSqlSession().insert("PaintDAO.inserAnswer", answer);
	}

	@Override
	public void deleteAnswer() {
		getSqlSession().delete("PaintDAO.deleteAnswer");
	}

}
