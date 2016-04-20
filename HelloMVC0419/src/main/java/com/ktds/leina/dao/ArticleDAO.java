package com.ktds.leina.dao;

import java.util.List;

import com.ktds.leina.vo.EmployeesVO;

public interface ArticleDAO {
	
	public String getNowSystemDate();
	public List<EmployeesVO> getAllEmployeeInfo();
}
