package com.ktds.mcjang.login.biz.impl;

import com.ktds.mcjang.common.util.PasswordUtil;
import com.ktds.mcjang.login.biz.LoginBiz;
import com.ktds.mcjang.login.dao.LoginDAO;
import com.ktds.mcjang.login.vo.UsersVO;

public class LoginBizImpl implements LoginBiz {

	public LoginDAO loginDAO;
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public UsersVO login(UsersVO usersVO) {
		
		UsersVO tempUserVO = usersVO.getClone();
		
		String salt = 
				this.loginDAO.getSaltByUserId(tempUserVO.getEmailId());
		
		tempUserVO.setSalt(salt);
		tempUserVO = PasswordUtil.getPassword(tempUserVO);
		
		tempUserVO = this.loginDAO.login(tempUserVO);
		tempUserVO.setPassword(usersVO.getPassword());
		
		return tempUserVO;
	}
	
}
