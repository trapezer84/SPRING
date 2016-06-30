package com.ktds.mcjang.board.vo;

import java.util.ArrayList;
import java.util.List;

import com.ktds.mcjang.common.util.Paging;

public class ArticleListVO {

	private List<ArticleVO> articleList;
	private Paging paging;
	
	public List<ArticleVO> getArticleList() {
		List<ArticleVO> temp = new ArrayList<ArticleVO>();
		temp.addAll(articleList);
		return temp;
	}
	public void setArticleList(List<ArticleVO> articleList) {
		List<ArticleVO> temp = new ArrayList<ArticleVO>();
		temp.addAll(articleList);
		this.articleList = temp;
	}
	
	public Paging getPaging() {
		return paging.getClone();
	}
	public void setPaging(Paging paging) {
		this.paging = paging.getClone();
	}
	
}
