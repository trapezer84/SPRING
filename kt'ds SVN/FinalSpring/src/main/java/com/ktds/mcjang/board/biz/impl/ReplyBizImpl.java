package com.ktds.mcjang.board.biz.impl;

import java.util.List;

import com.ktds.mcjang.board.biz.ReplyBiz;
import com.ktds.mcjang.board.dao.ReplyDAO;
import com.ktds.mcjang.board.vo.ArticleListVO;
import com.ktds.mcjang.board.vo.ArticleVO;
import com.ktds.mcjang.board.vo.ReplyVO;

public class ReplyBizImpl implements ReplyBiz {

	private ReplyDAO replyDAO;

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	@Override
	public List<ReplyVO> getReplies(int id) {
		return replyDAO.getReplies(id);
	}
	
	@Override
	public ArticleListVO getReplyCount(ArticleListVO articleList) {
		
		List<ArticleVO> articles = articleList.getArticleList();
		
		for(ArticleVO article : articles) {
			article.setReplyCount(replyDAO.getReplyCount(article.getArticleId()));
		}
		
		articleList.setArticleList(articles);
		
		return articleList;
	}
	
	@Override
	public void write(ReplyVO replyVO) {
		this.replyDAO.write(replyVO);
	}
	
	@Override
	public void modify(ReplyVO replyVO) {
		this.replyDAO.modify(replyVO);
	}
	
	@Override
	public void delete(ReplyVO replyVO) {
		this.replyDAO.delete(replyVO);
	}
	
	@Override
	public ReplyVO getReply(ReplyVO replyVO) {
		return this.replyDAO.getReply(replyVO);
	}
	
}
