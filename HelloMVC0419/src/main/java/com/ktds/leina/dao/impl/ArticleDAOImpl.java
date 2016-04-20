package com.ktds.leina.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.leina.dao.ArticleDAO;
import com.ktds.leina.vo.EmployeesVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO{

	@Override
	public String getNowSystemDate() {
		return getSqlSession().selectOne("ArticleDAO.getNowSystemDate");
	}

	@Override
	public List<EmployeesVO> getAllEmployeeInfo() {
		// 결과가 여러개 필요하므로 selectList, 한 개만 필요하면 selectOne
		String lastName = "King";
		
		// 앞에는 반드시 string, 두번째는 반드시 모든 것을 대표하는 object 
		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("firstName", "Steven");
//		parameters.put("lastName", "King");
		
		EmployeesVO employee = new EmployeesVO();
//		employee.setFirstName("Steven");
//		employee.setLastName("King");
		
		List<Integer> managerId = new ArrayList<Integer>();
		managerId.add(100);
		managerId.add(101);
		managerId.add(102);
		managerId.add(103);
		
		parameters.put("employee", employee);
		parameters.put("managerIds", managerId);
		
		return getSqlSession().selectList("ArticleDAO.getAllEmployeeInfo", parameters);
	}

}
