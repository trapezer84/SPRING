package com.ktds.mcjang.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.board.vo.ReplyVO;

public interface ReplyService {

	public ModelAndView write(HttpServletRequest request, ReplyVO replyVO, Errors errors);

	public ReplyVO getReply(int articleId, int replyId);

	public ModelAndView modify(HttpServletRequest request, ReplyVO replyVO, Errors errors);

	public ModelAndView delete(HttpServletRequest request, int articleId, int replyId);

}
