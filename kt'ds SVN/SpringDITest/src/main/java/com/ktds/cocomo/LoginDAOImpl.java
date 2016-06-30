package com.ktds.cocomo;

public class LoginDAOImpl implements LoginDAO{

	
	
	@Override
	public boolean login() {
		System.out.println("로그인에 성공했습니다.");
		return true;
	}

}
