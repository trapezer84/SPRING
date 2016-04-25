package com.ktds.bhyu.handler.socket.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.bhyu.handler.socket.dao.PaintDAO;
import com.ktds.bhyu.handler.socket.vo.Answer;

public class PaintDAOImpl extends SqlSessionDaoSupport implements PaintDAO {

	@Override
	public Answer getAnswer() {
		return getSqlSession().selectOne("PaintDAO.getAnswer");
	}

	@Override
	public void insertAnswer(Answer answer) {
		getSqlSession().update("PaintDAO.insertAnswer", answer);
	}

	@Override
	public void deleteAnswer() {
		getSqlSession().delete("PaintDAO.deleteAnswer");
	}

}
