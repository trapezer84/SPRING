package com.ktds.hskim.article.service.impl;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.service.ArticleService;
import com.ktds.hskim.article.vo.ArticleListVO;
import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.article.vo.ArticleVO;

import kr.co.hucloud.utilities.web.Paging;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleBiz articleBiz;
	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}


	@Override
	public ModelAndView writeNewArticle(ArticleVO articleVO, Errors errors) {
		ModelAndView view = new ModelAndView();
		boolean result;
		
		if ( articleVO.getArticleId() == "" ) {
			
			if ( errors.hasErrors() ) {
				view.setViewName("article/write");
				view.addObject("articleVO", articleVO);
				return view;
			}
			else {
				result = articleBiz.writeNewArticle(articleVO);
				
				if (result) {
					view.setViewName("redirect:/list");
				}
				else {
					throw new RuntimeException("일시적인 장애 발생");
				}
				
			}
		}
		else {
			result = articleBiz.updateArticle(articleVO);
			
			if (result) {
				view.setViewName("redirect:/detail/" + articleVO.getArticleId());
			}
			else {
				view.setViewName("redirect:/detail/" + articleVO.getArticleId());
			}			
		}
		
		return view;
	}


	@Override
	public ModelAndView getAllArticleList(int pageNo) {
		
		ArticleListVO articleListVO = new ArticleListVO();
		Paging paging = new Paging();
		
		articleListVO.setPaging(paging);
		
		paging.setPageNumber(pageNo + "");
		
		int totalArticleCount = articleBiz.getTotalArticleCount();
		paging.setTotalArticleCount(totalArticleCount);
		
		ArticleSearchVO searchVO = new ArticleSearchVO();
		searchVO.setStartIndex(paging.getStartArticleNumber());
		searchVO.setEndIndex(paging.getEndArticleNumber());
		
		List<ArticleVO> articleList = articleBiz.getAllArticle(searchVO);
		articleListVO.setArticleList(articleList);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("article/list");
		view.addObject("articleListVO", articleListVO);
		
		return view;
	}


	@Override
	public ArticleVO getOneArticle(String articleId) {
		return articleBiz.getOneArticle(articleId);
	}


	@Override
	public ModelAndView deleteArticle(String articleId) {
		
		ModelAndView view = new ModelAndView();
		
		boolean result = articleBiz.deleteArticle(articleId);
		
		if ( result ) {
			view.setViewName("redirect:/list");
		}
		else {
			throw new RuntimeException("삭제 실패");
		}
		
		return view;
	}


	@Override
	public ModelAndView modifyArticle(String articleId) {
		
		ModelAndView view = new ModelAndView();
		
		ArticleVO articleVO = articleBiz.getOneArticle(articleId);
		
		if ( articleVO != null ) {
			view.addObject("articleVO", articleVO);
			view.setViewName("article/write");
		}
		else {
			throw new RuntimeException("이미 삭제되었거나 존재하지 않는 게시글");
		}
		
		return view;
	}

}
