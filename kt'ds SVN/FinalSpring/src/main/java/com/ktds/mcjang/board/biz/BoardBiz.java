package com.ktds.mcjang.board.biz;

import com.ktds.mcjang.board.vo.ArticleListVO;
import com.ktds.mcjang.board.vo.ArticleSearchVO;
import com.ktds.mcjang.board.vo.ArticleVO;

public interface BoardBiz {

	public void write(ArticleVO articleVO);
	public ArticleVO getArticle(int id);
	public ArticleListVO getList(ArticleSearchVO articleSearchVO);
	public void modify(ArticleVO articleVO);
	public void delete(ArticleVO articleVO);
	public void updateHitCount(String id);
	public void updateRecommendCount(String id);
	
}
