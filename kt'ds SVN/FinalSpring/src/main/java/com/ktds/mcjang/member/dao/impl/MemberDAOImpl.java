package com.ktds.mcjang.member.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.login.vo.UsersVO;
import com.ktds.mcjang.member.dao.MemberDAO;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {

	@Override
	public boolean checkEmailIdDuplicate(String emailId) {
		int count = getSqlSession().selectOne("memberDAO.checkEmailIdDuplicate", emailId);
		return count > 0;
	}
	
	@Override
	public void regist(UsersVO usersVO) {
		getSqlSession().insert("memberDAO.registAndUpdate", usersVO);
	}

	@Override
	public void exit(UsersVO usersVO) {
		// 물리적 삭제 하지 않음.
		getSqlSession().update("memberDAO.registAndUpdate", usersVO);
	}

	@Override
	public void update(UsersVO usersVO) {
		getSqlSession().update("memberDAO.registAndUpdate", usersVO);
	}

	@Override
	public List<UsersVO> getAllMemberList() {
		throw new RuntimeException("아직 기능이 구현되지 않았습니다.");
	}
	
	@Override
	public void addPoint(UsersVO usersVO) {
		getSqlSession().update("memberDAO.addPoint", usersVO);
	}
	
	@Override
	public void minusPoint(UsersVO usersVO) {
		getSqlSession().update("memberDAO.minusPoint", usersVO);
	}

}








