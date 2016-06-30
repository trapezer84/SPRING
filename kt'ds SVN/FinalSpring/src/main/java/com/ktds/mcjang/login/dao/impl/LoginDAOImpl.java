package com.ktds.mcjang.login.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.login.dao.LoginDAO;
import com.ktds.mcjang.login.vo.UsersVO;

public class LoginDAOImpl extends SqlSessionDaoSupport implements LoginDAO {

	@Override
	public UsersVO login(UsersVO usersVO) {
		UsersVO loginedUser = 
				getSqlSession().selectOne("loginDAO.login", usersVO);
		
		return loginedUser;
	}
	
	@Override
	public String getSaltByUserId(String emailId) {
		return getSqlSession()
				.selectOne("loginDAO.getSaltByUserId", emailId);
	}
	
}






