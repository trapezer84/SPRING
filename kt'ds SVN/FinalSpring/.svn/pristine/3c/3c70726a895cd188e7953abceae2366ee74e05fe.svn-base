package com.ktds.mcjang.board.dao;

import java.util.List;

import com.ktds.mcjang.board.vo.ArticleSearchVO;
import com.ktds.mcjang.board.vo.ArticleVO;

public interface BoardDAO{

	public void write(ArticleVO articleVO);
	public ArticleVO getArticle(int id);
	public List<ArticleVO> getList(ArticleSearchVO articleSearchVO);
	public void modify(ArticleVO articleVO);
	public void delete(ArticleVO articleVO);
	public void updateHitCount(String id);
	public void updateRecommendCount(String id);
	public int getArticleCount(ArticleSearchVO articleSearchVO);
	
}
