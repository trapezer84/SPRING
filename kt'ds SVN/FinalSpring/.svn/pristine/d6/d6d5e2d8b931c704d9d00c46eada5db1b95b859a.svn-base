package com.ktds.mcjang.login.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.history.biz.HistoryBiz;
import com.ktds.mcjang.history.vo.HistoryVO;
import com.ktds.mcjang.history.vo.HistoryVO.OperationHistory;
import com.ktds.mcjang.login.biz.LoginBiz;
import com.ktds.mcjang.login.service.LoginService;
import com.ktds.mcjang.login.vo.UsersVO;

public class LoginServiceImpl implements LoginService {

	private LoginBiz loginBiz;
	private HistoryBiz historyBiz;
	
	public void setLoginBiz(LoginBiz loginBiz) {
		this.loginBiz = loginBiz;
	}
	public void setHistoryBiz(HistoryBiz historyBiz) {
		this.historyBiz = historyBiz;
	}

	@Override
	public ModelAndView login(UsersVO usersVO, Errors errors,
			HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		UsersVO userInfo = this.loginBiz.login(usersVO);
		
		HistoryVO loginHistoryVO = new HistoryVO();
		loginHistoryVO.setEmailId(usersVO.getEmailId());
		loginHistoryVO.setIp(request.getRemoteAddr());
		loginHistoryVO.setOperationType(OperationHistory.LOGIN_HISTORY);
		
		if(userInfo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("_MEMBER_", userInfo);
			
			view.setViewName("redirect:/member/mypage");
			
			loginHistoryVO.setOperationDescription("로그인에 성공했습니다!");
			
		}
		else {
			view.addObject("error", "ID 혹은 비밀번호가 틀렸습니다.");
			view.setViewName("login/login");
			
			loginHistoryVO.setOperationDescription("로그인에 실패했습니다!");
		}
		
		historyBiz.putHistory(loginHistoryVO);
		
		return view;
	}
	
}
