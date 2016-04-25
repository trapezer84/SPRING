package com.ktds.bhyu.handler.socket.dao;

import com.ktds.bhyu.handler.socket.vo.Answer;

public interface PaintDAO {
	
	public Answer getAnswer();
	
	public void insertAnswer(Answer answer);
	public void deleteAnswer();
	
}
