package com.hucloud.mvc.sample5.biz;

import java.util.List;

import com.hucloud.mvc.sample5.dao.MemberDAO;

public class MemberBizImpl implements MemberBiz {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<String> getMemberList() {
		return this.memberDAO.selectMemberList();
	}
}
