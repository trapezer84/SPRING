package com.ktds.leina.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.leina.vo.LoginVO;

@Controller
public class BadgeController {
	
	@RequestMapping("/newMember")
	@ResponseBody
	public LoginVO getNewMemberCountForAjax() {
		LoginVO loginVO = new LoginVO();
		loginVO.setId("leina");
		loginVO.setMemberNumber(1);
		loginVO.setEnableAutoLogin(true);
		return loginVO;
	}
	
}
