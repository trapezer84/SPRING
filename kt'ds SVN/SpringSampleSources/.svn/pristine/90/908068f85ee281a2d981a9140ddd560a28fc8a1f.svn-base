package com.hucloud.mvc.sample1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * web.xml에 Controller 및 기타 자원들에 대한 설정이 존재함.
 * 
 * @author mcjang
 *
 */
@Controller
public class MemberController {
	
	@RequestMapping("/member/list")
	public void viewMemberListPage() {
		System.out.println("/member/list 호출됨.");
	}
	
	@RequestMapping(value="/member/detail/{userId}", method=RequestMethod.GET)
	public void viewMemberDetailPageByUserId(@PathVariable String userId) {
		System.out.println("/member/detail/{userId} 호출됨. userId = " + userId);
	}
	
	@RequestMapping(value="/member/update/{userId}", method=RequestMethod.POST)
	public void viewMemberUpdatePageByUserId(@PathVariable String userId) {
		System.out.println("/member/detail/{userId} 호출됨. userId = " + userId);
	}
	
}
