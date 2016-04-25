package com.ktds.bhyu.article.service.impl;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.bhyu.article.biz.ArticleBiz;
import com.ktds.bhyu.article.service.ArticleService;
import com.ktds.bhyu.article.vo.ArticleListVO;
import com.ktds.bhyu.article.vo.ArticleSearchVO;
import com.ktds.bhyu.article.vo.ArticleVO;

import kr.co.hucloud.utilities.web.Paging;

public class ArticleServiceImpl implements ArticleService {

	private ArticleBiz articleBiz;
	
	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}


	@Override
	public ModelAndView writeNewArticle(ArticleVO articleVO, Errors errors) {
		ModelAndView view = new ModelAndView();
		
		if ( articleVO.getArticleId() == null ) {
			if ( errors.hasErrors() ) {
				view.setViewName("article/write");
				view.addObject("articleVO", articleVO);
				return view;
			}
			else {
				boolean result = articleBiz.writeNewArticle(articleVO);
				
				if ( result ) {
					view.setViewName("redirect:/list");
				}
				else {
					throw new RuntimeException("일시적인 장애가 발생했습니다. 잠시후 다시 시도해주세요.");
				}
			}
		}
		else {
			if ( errors.hasErrors() ) {
				view.setViewName("article/write");
				view.addObject("articleVO", articleVO);
				return view;
			}
			else {
				boolean result = articleBiz.doModifyArticle(articleVO);
				
				if ( result ) {
					view.setViewName("redirect:/detail/"+articleVO.getArticleId());
				}
				else {
					throw new RuntimeException("일시적인 장애가 발생했습니다. 잠시후 다시 시도해주세요.");
				}
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
	public ModelAndView getOneArticle(String articleId) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("article/detail");
		view.addObject("article", articleBiz.getOneArticle(articleId));
		
		return view;
	}


	@Override
	public ModelAndView doDeleteArticle(String articleId) {
		ModelAndView view = new ModelAndView();
		boolean result = articleBiz.doDeleteArticle(articleId);
		
		if ( result ) {
			view.setViewName("redirect:/list");
		}
		else {
			throw new RuntimeException("일시적인 장애가 발생했습니다. 잠시후 다시 시도해주세요.");
		}
		
		return view;
	}


	@Override
	public ModelAndView viewModifyPage(String articleId) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("article/write");
		view.addObject("article", articleBiz.getOneArticle(articleId));
		return view;
	}

}
