package com.hucloud.mvc.sample7.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {

	@Override
	public List<String> selectMemberList() {
		
		List<String> memberList = new ArrayList<String>();
		memberList.add("장민창1");
		memberList.add("장민창2");
		memberList.add("장민창3");
		
		return memberList;
	}
	
}
