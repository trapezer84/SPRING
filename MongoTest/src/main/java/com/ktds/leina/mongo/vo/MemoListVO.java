package com.ktds.leina.mongo.vo;

import java.util.List;
import java.util.Map;

import com.ktds.leina.mongo.util.Paging;

/**
 * @author 206-025
 *
 */
public class MemoListVO {

	private Paging paging;
	private List<Map> memoList;
	
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	public List<Map> getMemoList() {
		return memoList;
	}
	public void setMemoList(List<Map> memoList) {
		this.memoList = memoList;
	}
	
}
