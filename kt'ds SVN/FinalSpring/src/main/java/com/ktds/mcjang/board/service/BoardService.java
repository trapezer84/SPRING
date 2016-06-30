package com.ktds.mcjang.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.board.vo.ArticleVO;

public interface BoardService {

	public ModelAndView write(HttpServletRequest request, ArticleVO articleVO, Errors errors);
	public ModelAndView getArticle(HttpSession session, int id);
	public ModelAndView viewInitList(HttpSession session);
	public ModelAndView getList(HttpServletRequest request);
	public ModelAndView viewModify(HttpSession session, int articleId);
	public ModelAndView modify(HttpServletRequest request, ArticleVO articleVO, Errors errors);
	public ModelAndView delete(HttpServletRequest request, int id);
	public ModelAndView updateHitCount(String id);
	public ModelAndView updateRecommendCount(String id);
	
}
