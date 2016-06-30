package com.hucloud.mvc.sample6.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hucloud.mvc.sample6.dao.MemberDAO;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<String> getMemberList() {
		return this.memberDAO.selectMemberList();
	}
}
