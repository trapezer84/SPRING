package com.ktds.leina.article.service.impl;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.article.biz.ArticleBiz;
import com.ktds.leina.article.service.ArticleService;
import com.ktds.leina.article.vo.ArticleListVO;
import com.ktds.leina.article.vo.ArticleSearchVO;
import com.ktds.leina.article.vo.ArticleVO;

import kr.co.hucloud.utilities.web.Paging;

public class ArticleServiceImpl implements ArticleService {
	private ArticleBiz articleBiz;

	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}

	@Override
	public ModelAndView writeNewArticle(ArticleVO articleVO, Errors errors) {
		ModelAndView view = new ModelAndView();

		// 에러가 잡혔는지 확인한다
		if (errors.hasErrors()) {
			view.setViewName("article/write");
			view.addObject("articleVO", articleVO);
			return view;
		} else {
			boolean result = articleBiz.writeNewArticle(articleVO);
			if (result) {
				view.setViewName("redirect:/list");
			}
			else {
				throw new RuntimeException("일시적인 장애가 발생했습니다. 잠시후 다시 시도해주세요.");
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
	public ModelAndView getOneArticle(String articleID) {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/detail");
		view.addObject("article", articleBiz.getOneArticle(articleID));
		return view;
	}

	@Override
	public void deleteOneArticle(String articleID) {
		articleBiz.deleteOneArticle(articleID);
	}

	@Override
	public void editArticle(ArticleVO articleVO) {
		ArticleVO originArticleVO = articleBiz.getOneArticle(articleVO.getArticleID());
		ArticleVO newArticleVO = new ArticleVO();
		newArticleVO.setArticleID(articleVO.getArticleID());
		// 제목 
		if(!articleVO.getSubject().equals(originArticleVO.getSubject()) ) {
			newArticleVO.setSubject(articleVO.getSubject());
		} 
		// 내용
		else if (!articleVO.getDescription().equals(originArticleVO.getDescription()) ) {
			newArticleVO.setDescription(articleVO.getDescription());
		}
		
		articleBiz.editArticle(newArticleVO);
	}

	@Override
	public ModelAndView getOneArticleForEdit(String articleID) {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/edit");
		view.addObject("article", articleBiz.getOneArticle(articleID));
		return view;
	}

}
