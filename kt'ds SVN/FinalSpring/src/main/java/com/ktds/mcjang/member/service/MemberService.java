package com.ktds.mcjang.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.login.vo.UsersVO;

public interface MemberService {

	public ModelAndView regist(UsersVO usersVO, Errors errors, HttpServletRequest request);
	public ModelAndView exit(HttpServletRequest request);
	public ModelAndView update(UsersVO usersVO, Errors errors, HttpServletRequest request);
	public ModelAndView getMemberInfo(HttpSession session);
	public List<UsersVO> getAllMemberList();
	public boolean checkEmailIdDuplicate(String emailId);
	
}
