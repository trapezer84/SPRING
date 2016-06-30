package com.ktds.mcjang.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.board.service.BoardService;
import com.ktds.mcjang.board.vo.ArticleVO;

@Controller
public class BoardController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/write")
	public ModelAndView viewWrite() {
		ModelAndView view = new ModelAndView();
		view.setViewName("board/write");
		return view;
	}
	
	@RequestMapping("/board/doWrite")
	public ModelAndView write(HttpServletRequest request
								, @Valid ArticleVO articleVO
								, Errors errors) {
		return this.boardService.write(request, articleVO, errors);
	}
	
	@RequestMapping("/board/list/init")
	public ModelAndView viewInitList(HttpSession session) {
		return this.boardService.viewInitList(session);
	}
	
	@RequestMapping("/board/list")
	public ModelAndView viewList(HttpServletRequest request) {
		return this.boardService.getList(request);
	}
	
	@RequestMapping("/board/detail/{articleId}")
	public ModelAndView viewDetail(HttpSession session, @PathVariable int articleId) {
		return this.boardService.getArticle(session, articleId);
	}
	
	@RequestMapping("/board/modify/{articleId}")
	public ModelAndView viewModify(HttpSession session, @PathVariable int articleId) {
		return this.boardService.viewModify(session, articleId);
	}
	
	@RequestMapping("/board/doModify")
	public ModelAndView doModify(HttpServletRequest request, @Valid ArticleVO articleVO, Errors errors) {
		return this.boardService.modify(request, articleVO, errors);
	}
	
	@RequestMapping("/board/delete/{articleId}")
	public ModelAndView delete(HttpServletRequest request, @PathVariable int articleId) {
		return this.boardService.delete(request, articleId);
	}
	
}
