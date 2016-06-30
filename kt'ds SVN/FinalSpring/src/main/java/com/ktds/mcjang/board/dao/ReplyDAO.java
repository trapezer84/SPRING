package com.ktds.mcjang.board.dao;

import java.util.List;

import com.ktds.mcjang.board.vo.ReplyVO;

public interface ReplyDAO {

	public List<ReplyVO> getReplies(int id);

	public int getReplyCount(int articleId);

	public void write(ReplyVO replyVO);

	public ReplyVO getReply(ReplyVO replyVO);

	public void modify(ReplyVO replyVO);

	public void delete(ReplyVO replyVO);

}
