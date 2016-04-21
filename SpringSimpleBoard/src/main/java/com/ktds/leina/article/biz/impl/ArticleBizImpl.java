package com.ktds.leina.article.biz.impl;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.biz.ArticleBiz;
import com.ktds.leina.article.dao.ArticleDAO;
import com.ktds.leina.article.vo.ArticleSearchVO;
import com.ktds.leina.article.vo.ArticleVO;

public class ArticleBizImpl implements ArticleBiz {

	private ArticleDAO articleDAO;

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public boolean writeNewArticle(ArticleVO articleVO) {

		// 구현되지 않은 것
		// throw new NotImplementedException();

		int nextArticleId = articleDAO.nextArticleSeq();
		String nowDate = articleDAO.nowDate();

		/*
		 * articleId의 형식 AR-20160421-000001
		 */
		String articleId = "AR-" + nowDate + "-" + lpad(nextArticleId+"", 6, "0");

		articleVO.setArticleNumber(nextArticleId);
		articleVO.setArticleID(articleId);
		return articleDAO.insertNewArticle(articleVO) > 0;
	}

	/**
	 * DB의 LPAD를 사용하는 코드
	 * @param source  : 원본
	 * @param length : 만들어져야하는 길이
	 * @param defValue : 채워질 글자
	 * @return
	 */
	private String lpad(String source, int length, String defValue) {

		/*
		 * 100 : 3
		 * 000100 : 6
		 */

		int sourceLength = source.length();
		int needLength = length - sourceLength;

		for (int i = 0; i < needLength; i++) {
			source = defValue + source;
		}

		return source;
	}

	@Override
	public int getTotalArticleCount() {
		return articleDAO.getTotalArticleCount();
	}

	@Override
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO) {
		return articleDAO.getAllArticle(searchVO);
	}

	@Override
	public ArticleVO getOneArticle(String articleID) {
		return articleDAO.getOneArticle(articleID);
	}

	@Override
	public void deleteOneArticle(String articleID) {
		articleDAO.deleteOneArticle(articleID);
	}

	@Override
	public void editArticle(ArticleVO articleVO) {
		articleDAO.editArticle(articleVO);
	}
}
