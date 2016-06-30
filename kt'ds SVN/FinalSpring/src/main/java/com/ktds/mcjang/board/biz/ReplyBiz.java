package com.ktds.mcjang.board.biz;

import java.util.List;

import com.ktds.mcjang.board.vo.ArticleListVO;
import com.ktds.mcjang.board.vo.ReplyVO;

public interface ReplyBiz {

	public List<ReplyVO> getReplies(int id);

	public ArticleListVO getReplyCount(ArticleListVO articleList);

	public void write(ReplyVO replyVO);

	public ReplyVO getReply(ReplyVO replyVO);

	public void modify(ReplyVO replyVO);

	public void delete(ReplyVO replyVO);

}
