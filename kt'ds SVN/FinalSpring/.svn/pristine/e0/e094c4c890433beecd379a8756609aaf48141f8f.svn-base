package com.ktds.mcjang.member.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ktds.mcjang.common.util.PasswordUtil;
import com.ktds.mcjang.login.vo.UsersVO;
import com.ktds.mcjang.member.biz.MemberBiz;
import com.ktds.mcjang.member.dao.MemberDAO;

public class MemberBizImpl implements MemberBiz {
	
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public boolean checkEmailIdDuplicate(String emailId) {
		return this.memberDAO.checkEmailIdDuplicate(emailId);
	}
	
	@Override
	public void regist(UsersVO usersVO) {
		
		usersVO = PasswordUtil.generatePassword(usersVO);
		
		this.memberDAO.regist(usersVO);
	}

	@Override
	public void exit(UsersVO usersVO) {
		this.memberDAO.exit(usersVO);
	}

	@Override
	public void update(UsersVO usersVO) {
		
		usersVO = PasswordUtil.generatePassword(usersVO);
		
		this.memberDAO.update(usersVO);
	}

	@Override
	public List<UsersVO> getAllMemberList() {
		return this.memberDAO.getAllMemberList();
	}
	
	@Override
	public void addPoint(String id, int point) {
		UsersVO usersVO = new UsersVO();
		usersVO.setEmailId(id);
		usersVO.setPoint(point);
		
		this.memberDAO.addPoint(usersVO);
	}
	
	@Override
	public void minusPoint(String id, int point) {
		UsersVO usersVO = new UsersVO();
		usersVO.setEmailId(id);
		usersVO.setPoint(point);
		
		this.memberDAO.minusPoint(usersVO);
	}

	
	
}
