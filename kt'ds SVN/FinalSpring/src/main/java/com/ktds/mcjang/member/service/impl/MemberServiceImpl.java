package com.ktds.mcjang.member.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.history.biz.HistoryBiz;
import com.ktds.mcjang.history.vo.HistoryVO;
import com.ktds.mcjang.history.vo.HistoryVO.OperationHistory;
import com.ktds.mcjang.login.biz.LoginBiz;
import com.ktds.mcjang.login.vo.UsersVO;
import com.ktds.mcjang.member.biz.MemberBiz;
import com.ktds.mcjang.member.service.MemberService;

public class MemberServiceImpl implements MemberService {

	private MemberBiz memberBiz;
	private LoginBiz loginBiz;
	private HistoryBiz historyBiz;
	
	public void setMemberBiz(MemberBiz memberBiz) {
		this.memberBiz = memberBiz;
	}
	public void setLoginBiz(LoginBiz loginBiz) {
		this.loginBiz = loginBiz;
	}
	public void setHistoryBiz(HistoryBiz historyBiz) {
		this.historyBiz = historyBiz;
	}
	
	@Override
	public boolean checkEmailIdDuplicate(String emailId) {
		return this.memberBiz.checkEmailIdDuplicate(emailId);
	}
	

	@Override
	public ModelAndView regist(UsersVO usersVO, Errors errors, HttpServletRequest request) {
		
		usersVO.setDeleteFlag("N");
		
		HistoryVO memberHistoryVO = new HistoryVO();
		memberHistoryVO.setEmailId(usersVO.getEmailId());
		memberHistoryVO.setIp(request.getRemoteAddr());
		memberHistoryVO.setOperationType(OperationHistory.MEMBER_HISTORY);
		
		String message = "";
		if(errors.hasErrors()) {
			message += "가입에 실패함. (ID : " + usersVO.getEmailId();
			message += "/NickName : " + usersVO.getUserName() + ")";
		}
		else {
			this.memberBiz.regist(usersVO);
			message += "가입에 성공함. (ID : " + usersVO.getEmailId();
			message += "/NickName : " + usersVO.getUserName() + ")";
		}
		
		memberHistoryVO.setOperationDescription(message);
		this.historyBiz.putHistory(memberHistoryVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/login");
		return view;
	}

	@Override
	public ModelAndView exit(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UsersVO loginedUser = (UsersVO) session.getAttribute("_MEMBER_");
		loginedUser.setDeleteFlag("Y");
		this.memberBiz.exit(loginedUser);
		
		session.invalidate();
		
		HistoryVO memberHistoryVO = new HistoryVO();
		memberHistoryVO.setEmailId(loginedUser.getEmailId());
		memberHistoryVO.setIp(request.getRemoteAddr());
		memberHistoryVO.setOperationType(OperationHistory.MEMBER_HISTORY);
		
		String message = loginedUser.getEmailId() + " 탈퇴함.";
		memberHistoryVO.setOperationDescription(message);
		this.historyBiz.putHistory(memberHistoryVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/member/regist");
		return view;
	}

	@Override
	public ModelAndView update(UsersVO usersVO, Errors errors, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		UsersVO loginedUser = (UsersVO) session.getAttribute("_MEMBER_");
		
		usersVO.setDeleteFlag("N");
		
		HistoryVO memberHistoryVO = new HistoryVO();
		memberHistoryVO.setEmailId(usersVO.getEmailId());
		memberHistoryVO.setIp(request.getRemoteAddr());
		memberHistoryVO.setOperationType(OperationHistory.MEMBER_HISTORY);
		
		String message = "";
		if(errors.hasErrors()) {
			message += "수정에 실패함. (ID : " + usersVO.getEmailId();
			message += "/NickName : " + usersVO.getUserName() + ")";
		}
		else {
			this.memberBiz.update(usersVO);
			
			UsersVO userInfo = this.loginBiz.login(usersVO);
			if(userInfo != null) {
				session.setAttribute("_MEMBER_", userInfo);
			}
			
			message += "수정에 성공함. (ID : " + usersVO.getEmailId();
			message += "/NickName : " + loginedUser.getUserName() + " -> " + usersVO.getUserName() + ")";
		}
		
		memberHistoryVO.setOperationDescription(message);
		this.historyBiz.putHistory(memberHistoryVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/member/mypage");
		return view;
	}

	@Override
	public ModelAndView getMemberInfo(HttpSession session) {
		UsersVO loginedUser = (UsersVO) session.getAttribute("_MEMBER_");
		
		String password = loginedUser.getPassword();
		
		System.out.println(loginedUser.getPassword());
		System.out.println(loginedUser.getPassword());
		System.out.println(loginedUser.getPassword());
		System.out.println(loginedUser.getPassword());
		System.out.println(loginedUser.getPassword());
		UsersVO userInfo = this.loginBiz.login(loginedUser);
		
		loginedUser.setPassword(password);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("member/mypage");
		view.addObject("userInfo", userInfo);
		return view;
	}

	@Override
	public List<UsersVO> getAllMemberList() {
		return this.memberBiz.getAllMemberList();
	}

}
