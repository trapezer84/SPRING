package com.ktds.hskim.article.biz.impl;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.dao.ArticleDAO;
import com.ktds.hskim.article.dao.OperationHistoryDAO;
import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.article.vo.ArticleVO;

public class ArticleBizImpl implements ArticleBiz {
	
	private ArticleDAO articleDAO;
	private OperationHistoryDAO operationHistoryDAO;
	
	public void setOperationHistoryDAO(OperationHistoryDAO operationHistoryDAO) {
		this.operationHistoryDAO = operationHistoryDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public boolean writeNewArticle(ArticleVO articleVO) {

		int nextArticleId = articleDAO.nextArtcleSeq();
		String nowDate = articleDAO.nowDate();
		/**
		 * ArticleID의 형식
		 * AR-20160421-000001
		 */
		String articleId = "AR-" + nowDate + "-" + lpad(nextArticleId+"", 6, "0");
		
		articleVO.setArticleId(articleId);
		articleVO.setArticleNumber(nextArticleId);
				
		operationHistoryDAO.insertHistory(articleId + "글을 작성함");
		return articleDAO.insertNewArticle(articleVO) > 0;
	}
	
	/**
	 * 
	 * @param source 원본
	 * @param length 만들어야할 길이
	 * @param defValue 채워질 글자
	 * @return
	 */
	private String lpad(String source, int length, String defValue) {
		/**
		 * 100 : 3
		 * 000:100 : 6
		 */
		int sourceLength = source.length();
		int needLength = length - sourceLength;
		
		for ( int i = 0; i < needLength; i++ ) {
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
	public ArticleVO getOneArticle(String articleId) {
		return articleDAO.getOneArticle(articleId);
	}

	@Override
	public boolean deleteArticle(String articleId) {
		
		return articleDAO.deleteArticle(articleId) > 0;
	}

	@Override
	public boolean updateArticle(ArticleVO articleVO) {
		
		// 원본 게시글 내용
		ArticleVO originArticle = articleDAO.getOneArticle(articleVO.getArticleId());
		// 변경 게시글 담을 객체
		ArticleVO changedArticle = new ArticleVO();
		changedArticle.setArticleId(articleVO.getArticleId());
		
		// 원본 내용과 수정한 내용과 비교하여 수정된 내용  변경할 객체에 set
		if ( !originArticle.getSubject().equals(articleVO.getSubject()) ) {
			changedArticle.setSubject(articleVO.getSubject());
		}
		if ( !originArticle.getDescription().equals(articleVO.getDescription()) ) {
			changedArticle.setDescription(articleVO.getDescription());
		}
		if ( !originArticle.getWriter().equals(articleVO.getWriter()) ) {
			changedArticle.setWriter(articleVO.getWriter());
		}
		
		// 변경할 객체가 비었다면 return false
		if ( changedArticle.getSubject() == null && changedArticle.getDescription() == null && changedArticle.getWriter() == null) {
			return false;
		}
		else {
			return articleDAO.updateArticle(changedArticle) > 0;
		}
	}
	
	
	
	
}


