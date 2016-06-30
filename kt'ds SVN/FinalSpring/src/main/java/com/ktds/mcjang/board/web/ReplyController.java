package com.ktds.mcjang.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.board.service.ReplyService;
import com.ktds.mcjang.board.vo.ReplyVO;

@Controller
public class ReplyController {

	private ReplyService replyService;

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@RequestMapping("/reply/write")
	public ModelAndView write(HttpServletRequest request, @Valid ReplyVO replyVO, Errors errors) {
		return replyService.write(request, replyVO, errors);
	}
	
	@RequestMapping("/reply/modify")
	public ModelAndView modify(HttpServletRequest request, @Valid ReplyVO replyVO, Errors errors) {
		return replyService.modify(request, replyVO, errors);
	}
	
	@RequestMapping("/reply/{articleId}/{replyId}")
	@ResponseBody
	public ReplyVO getReply(@PathVariable int articleId, @PathVariable int replyId) {
		return replyService.getReply(articleId, replyId);
	}
	
	@RequestMapping("/reply/delete/{articleId}/{replyId}")
	public ModelAndView delete(HttpServletRequest request, @PathVariable int articleId, @PathVariable int replyId) {
		return replyService.delete(request, articleId, replyId);
	}
	
	
}
