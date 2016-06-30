package com.ktds.mcjang.board.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.board.biz.ReplyBiz;
import com.ktds.mcjang.board.service.ReplyService;
import com.ktds.mcjang.board.vo.ReplyVO;
import com.ktds.mcjang.history.biz.HistoryBiz;
import com.ktds.mcjang.history.vo.HistoryVO;
import com.ktds.mcjang.history.vo.HistoryVO.OperationHistory;
import com.ktds.mcjang.login.biz.LoginBiz;
import com.ktds.mcjang.login.vo.UsersVO;
import com.ktds.mcjang.member.biz.MemberBiz;

public class ReplyServiceImpl implements ReplyService {

	private ReplyBiz replyBiz;
	private MemberBiz memberBiz;
	private HistoryBiz historyBiz;
	private LoginBiz loginBiz;

	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	public void setMemberBiz(MemberBiz memberBiz) {
		this.memberBiz = memberBiz;
	}
	public void setHistoryBiz(HistoryBiz historyBiz) {
		this.historyBiz = historyBiz;
	}
	public void setLoginBiz(LoginBiz loginBiz) {
		this.loginBiz = loginBiz;
	}


	@Override
	public ModelAndView write(HttpServletRequest request, ReplyVO replyVO, Errors errors) {
		
		HttpSession session = request.getSession();
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String id = userVO.getEmailId();
		
		HistoryVO historyVO = new HistoryVO();
		historyVO.setIp(request.getRemoteAddr());
		historyVO.setEmailId(id);
		historyVO.setOperationType(OperationHistory.REPLY_HISTORY);
		
		String message = "댓글 쓰기 %s : 내용 : %s";
		
		if(errors.hasErrors()) {
			historyVO.setOperationDescription(
					String.format(message
							, "실패"
							, replyVO.getContent()));
		}
		else {
			
			replyVO.setMemberId(id);
			replyVO.setContent(replyVO.getContent().replaceAll("\n", "<br/>").replaceAll("\r", ""));
			
			try {
				this.replyBiz.write(replyVO);
				this.memberBiz.addPoint(id, 5);
				this.loginBiz.login(userVO);
				
				UsersVO updatedUserVO = this.loginBiz.login(userVO);
				session.setAttribute("_MEMBER_", updatedUserVO);
				
				historyVO.setOperationDescription(
						String.format(message
								, "성공"
								, replyVO.getContent()));
			}
			catch(RuntimeException re) {
				historyVO.setOperationDescription(
						String.format(message
								, "실패"
								, replyVO.getContent()));
				throw re;
			}
			finally {
				this.historyBiz.putHistory(historyVO);
			}
			
		}
		
		return new ModelAndView("redirect:/board/detail/" + replyVO.getArticleId());
	}
	
	@Override
	public ModelAndView modify(HttpServletRequest request, ReplyVO replyVO,
			Errors errors) {
		HttpSession session = request.getSession();
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String id = userVO.getEmailId();
		
		HistoryVO historyVO = new HistoryVO();
		historyVO.setIp(request.getRemoteAddr());
		historyVO.setEmailId(id);
		historyVO.setOperationType(OperationHistory.REPLY_HISTORY);
		
		String message = "댓글 수정 %s : 내용 : %s";
		
		if(errors.hasErrors()) {
			historyVO.setOperationDescription(
					String.format(message
							, "실패"
							, replyVO.getContent()));
		}
		else {
			
			replyVO.setMemberId(id);
			replyVO.setContent(replyVO.getContent().replaceAll("\n", "<br/>").replaceAll("\r", ""));
			
			try {
				this.replyBiz.modify(replyVO);
				this.loginBiz.login(userVO);
				
				UsersVO updatedUserVO = this.loginBiz.login(userVO);
				session.setAttribute("_MEMBER_", updatedUserVO);
				
				historyVO.setOperationDescription(
						String.format(message
								, "성공"
								, replyVO.getContent()));
			}
			catch(RuntimeException re) {
				historyVO.setOperationDescription(
						String.format(message
								, "실패"
								, replyVO.getContent()));
				throw re;
			}
			finally {
				this.historyBiz.putHistory(historyVO);
			}
			
		}
		
		return new ModelAndView("redirect:/board/detail/" + replyVO.getArticleId());
	}
	
	@Override
	public ReplyVO getReply(int articleId, int replyId) {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setArticleId(articleId);
		replyVO.setReplyId(replyId);
		
		replyVO = this.replyBiz.getReply(replyVO);
		
		replyVO.setContent(
				replyVO.getContent().replaceAll("<br/>", "\n")
				);
		
		return replyVO;
	}
	
	@Override
	public ModelAndView delete(HttpServletRequest request, int articleId, int replyId) {
		
		HttpSession session = request.getSession();
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String id = userVO.getEmailId();
		
		HistoryVO historyVO = new HistoryVO();
		historyVO.setIp(request.getRemoteAddr());
		historyVO.setEmailId(id);
		historyVO.setOperationType(OperationHistory.REPLY_HISTORY);
		
		String message = "댓글 삭제 %s : 번호 : %d";
		
		ReplyVO replyVO = new ReplyVO();
		replyVO.setArticleId(articleId);
		replyVO.setReplyId(replyId);
		
		try {
			
			this.replyBiz.delete(replyVO);
			this.memberBiz.minusPoint(id, 3);
			this.loginBiz.login(userVO);
			
			UsersVO updatedUserVO = this.loginBiz.login(userVO);
			session.setAttribute("_MEMBER_", updatedUserVO);
			
			historyVO.setOperationDescription(
					String.format(message
							, "성공"
							, replyVO.getReplyId()));
		}
		catch(RuntimeException re) {
			historyVO.setOperationDescription(
					String.format(message
							, "실패"
							, replyVO.getReplyId()));
			throw re;
		}
		finally {
			this.historyBiz.putHistory(historyVO);
		}
		
		return new ModelAndView("redirect:/board/detail/" + articleId);
	}
	
}
