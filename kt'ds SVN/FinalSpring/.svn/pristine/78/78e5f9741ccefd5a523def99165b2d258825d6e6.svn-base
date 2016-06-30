package com.ktds.mcjang.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.common.util.AjaxUtil;
import com.ktds.mcjang.login.vo.UsersVO;
import com.ktds.mcjang.member.service.MemberService;

@Controller
public class MemberController {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/member/checkEmailIdDuplicate")
	public void checkEmailIdDuplicate(@RequestParam String emailId, HttpServletResponse response) {
		
		boolean isDuplicate = false;
		isDuplicate = this.memberService.checkEmailIdDuplicate(emailId);
		
		AjaxUtil.sendResponse(response, "" + isDuplicate);
		
		
	}
	
	@RequestMapping("/member/regist")
	public ModelAndView registView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("member/regist");
		return view;
	}
	
	@RequestMapping(value="/member/doRegist", method=RequestMethod.POST)
	public ModelAndView doRegist(@Valid UsersVO usersVO, Errors errors, HttpServletRequest request) {
		return this.memberService.regist(usersVO, errors, request);
	}
	
	@RequestMapping("/member/mypage")
	public ModelAndView mypageView(HttpSession session) {
		return this.memberService.getMemberInfo(session);
	}
	
	@RequestMapping("/member/doModify")
	public ModelAndView doModify(@Valid UsersVO usersVO, Errors errors, HttpServletRequest request) {
		return this.memberService.update(usersVO, errors, request);
	}
	
	@RequestMapping("/member/doUnregist")
	public ModelAndView doUnregist(HttpServletRequest request) {
		return this.memberService.exit(request);
	}
	
}
