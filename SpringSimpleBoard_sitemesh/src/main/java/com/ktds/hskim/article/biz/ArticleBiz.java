package com.ktds.hskim.article.biz;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.article.vo.ArticleVO;

public interface ArticleBiz {
	
	public boolean writeNewArticle(ArticleVO articleVO);

	public int getTotalArticleCount();

	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO);

	public ArticleVO getOneArticle(String articleId);

	public boolean deleteArticle(String articleId);

	public boolean updateArticle(ArticleVO articleVO);

}


