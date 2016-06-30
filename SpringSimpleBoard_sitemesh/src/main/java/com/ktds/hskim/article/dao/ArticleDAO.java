package com.ktds.hskim.article.dao;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.article.vo.ArticleVO;

public interface ArticleDAO {
	
	/**
	 * 글 쓰기 공통 메소드
	 */
	public int nextArtcleSeq();
	public String nowDate();
	
	
	public int insertNewArticle(ArticleVO articleVO);
	public int getTotalArticleCount();
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO);
	public ArticleVO getOneArticle(String articleId);
	public int deleteArticle(String articleId);
	public int updateArticle(ArticleVO articleVO);
	
}
