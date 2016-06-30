package com.ktds.mcjang.member.dao;

import java.util.List;
import java.util.Map;

import com.ktds.mcjang.login.vo.UsersVO;

public interface MemberDAO {

	public void regist(UsersVO usersVO);
	public void exit(UsersVO usersVO);
	public void update(UsersVO usersVO);
	public List<UsersVO> getAllMemberList();
	public boolean checkEmailIdDuplicate(String emailId);
	
	public void addPoint(UsersVO usersVO);
	public void minusPoint(UsersVO usersVO);
	
}
