package com.ktds.mcjang.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.board.dao.ReplyDAO;
import com.ktds.mcjang.board.vo.ReplyVO;

public class ReplyDAOImpl extends SqlSessionDaoSupport implements ReplyDAO {

	@Override
	public List<ReplyVO> getReplies(int id) {
		return getSqlSession().selectList("replyDAO.getReplies", id);
	}
	
	@Override
	public int getReplyCount(int articleId) {
		return getSqlSession().selectOne("replyDAO.getReplyCount", articleId);
	}
	
	@Override
	public void write(ReplyVO replyVO) {
		getSqlSession().insert("replyDAO.write", replyVO);
	}
	
	@Override
	public void modify(ReplyVO replyVO) {
		getSqlSession().update("replyDAO.modify", replyVO);
	}
	
	@Override
	public void delete(ReplyVO replyVO) {
		getSqlSession().delete("replyDAO.delete", replyVO);
	}
	
	@Override
	public ReplyVO getReply(ReplyVO replyVO) {
		return getSqlSession().selectOne("replyDAO.getReply", replyVO);
	}
	
}
