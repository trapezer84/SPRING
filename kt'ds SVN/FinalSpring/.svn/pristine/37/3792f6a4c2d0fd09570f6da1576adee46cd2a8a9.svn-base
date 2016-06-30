package com.ktds.mcjang.board.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.board.biz.BoardBiz;
import com.ktds.mcjang.board.biz.ReplyBiz;
import com.ktds.mcjang.board.service.BoardService;
import com.ktds.mcjang.board.vo.ArticleListVO;
import com.ktds.mcjang.board.vo.ArticleSearchVO;
import com.ktds.mcjang.board.vo.ArticleVO;
import com.ktds.mcjang.board.vo.ReplyVO;
import com.ktds.mcjang.common.util.Paging;
import com.ktds.mcjang.common.util.RequestUtil;
import com.ktds.mcjang.common.util.SearchDateUtil;
import com.ktds.mcjang.history.biz.HistoryBiz;
import com.ktds.mcjang.history.vo.HistoryVO;
import com.ktds.mcjang.history.vo.HistoryVO.OperationHistory;
import com.ktds.mcjang.login.biz.LoginBiz;
import com.ktds.mcjang.login.vo.UsersVO;
import com.ktds.mcjang.member.biz.MemberBiz;

public class BoardServiceImpl implements BoardService  {
	
	private BoardBiz boardBiz;
	private ReplyBiz replyBiz;
	private HistoryBiz historyBiz;
	private LoginBiz loginBiz;
	private MemberBiz memberBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	public void setHistoryBiz(HistoryBiz historyBiz) {
		this.historyBiz = historyBiz;
	}
	public void setMemberBiz(MemberBiz memberBiz) {
		this.memberBiz = memberBiz;
	}
	public void setLoginBiz(LoginBiz loginBiz) {
		this.loginBiz = loginBiz;
	}

	@Override
	public ModelAndView write(HttpServletRequest request, ArticleVO articleVO, Errors errors) {
		
		HttpSession session = request.getSession();
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String id = userVO.getEmailId();
		
		articleVO.setEmailId(id);
		
		this.boardBiz.write(articleVO);
		this.memberBiz.addPoint(id, 15);
		this.loginBiz.login(userVO);
		
		HistoryVO historyVO = new HistoryVO();
		historyVO.setEmailId(id);
		historyVO.setIp(request.getRemoteAddr());
		historyVO.setOperationType(OperationHistory.BOARD_HISTORY);
		String message = "글쓰기 성공 : 제목 : %s, 내용 : %s";
		historyVO.setOperationDescription(
				String.format(message
						, articleVO.getSubject()
						, articleVO.getContent()));
		
		this.historyBiz.putHistory(historyVO);
		
		UsersVO updatedUserVO = this.loginBiz.login(userVO);
		session.setAttribute("_MEMBER_", updatedUserVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board/list");
		return view;
		
	}

	@Override
	public ModelAndView getArticle(HttpSession session, int id) {
		
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String emailId = userVO.getEmailId();
		
		ArticleVO articleVO = this.boardBiz.getArticle(id);
		if( !articleVO.getEmailId().equals(emailId) ) {
			if(userVO.getPoint() < 5) {
				throw new RuntimeException("포인트가 모자랍니다.");
			}
			
			this.memberBiz.minusPoint(emailId, 5);
			UsersVO updatedUserVO = this.loginBiz.login(userVO);
			session.setAttribute("_MEMBER_", updatedUserVO);
		}
		
		List<ReplyVO> replies = this.replyBiz.getReplies(id);
		
		for(ReplyVO reply : replies) {
			reply.setIsMyReply(reply.getMemberId().equals(emailId));
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("board/detail");
		view.addObject("articleVO", articleVO);
		view.addObject("replies", replies);
		return view;
	}

	@Override
	public ModelAndView viewInitList(HttpSession session) {
		session.removeAttribute("_SEARCH_KEYWORD_");
		return new ModelAndView("redirect:/board/list");
	}
	
	@Override
	public ModelAndView getList(HttpServletRequest request) {
	
		ArticleSearchVO articleSearchVO = new ArticleSearchVO();
		HttpSession session = request.getSession();
		
		ArticleSearchVO searchVOInSession = (ArticleSearchVO) 
				session.getAttribute("_SEARCH_KEYWORD_");
		
		if(searchVOInSession == null) {
			searchVOInSession = new ArticleSearchVO();
			searchVOInSession.setPaging(new Paging());
		}
		
		Paging paging = new Paging();
//		paging.setPageNumber(request.getParameter("pageNo"));
		paging.setPageNumber(RequestUtil.
				getParam(request,
						"pageNo", 
						searchVOInSession.getPaging().
						getPageNo() + ""));
		
		articleSearchVO.setPaging(paging);
		
		String searchStartYear = ""
				, searchStartMonth = ""
				, searchStartDay = "";
		String searchEndYear = ""
				, searchEndMonth = ""
				, searchEndDay = "";
		
		// 초기페이지를 보여줄 경우
//		if(searchVOInSession.getStartSearchYear() == null) {
			
			Calendar past = Calendar.getInstance();
			past.add(Calendar.MONTH, -3);
//			searchStartYear = RequestUtil.getParam(request
//					, "startYear", past.get(Calendar.YEAR) + "");
			searchStartYear = RequestUtil.getParam(request, "startYear"
					, SearchDateUtil.getYear(
							past, searchVOInSession.getStartSearchYear()));
			
//			searchStartMonth = RequestUtil.getParam(request
//					, "startMonth", (past.get(Calendar.MONTH) + 1) + "");
			searchStartMonth = RequestUtil.getParam(request
					, "startMonth"
					, SearchDateUtil.getMonth(
							past, searchVOInSession.getStartSearchMonth()));
			
//			searchStartDay = RequestUtil.getParam(request
//					, "startDate", past.get(Calendar.DAY_OF_MONTH) + "");
			searchStartDay = RequestUtil.getParam(request
					, "startDate"
					, SearchDateUtil.getDay(
							past, searchVOInSession.getStartSearchDay()));

			Calendar now = Calendar.getInstance();
			searchEndYear = RequestUtil.getParam(request
					, "endYear"
					, SearchDateUtil.getYear(now, searchVOInSession.getEndSearchYear()));
			
			searchEndMonth = RequestUtil.getParam(request
					, "endMonth"
					, SearchDateUtil.getMonth(now, searchVOInSession.getEndSearchMonth()));
			
			searchEndDay = RequestUtil.getParam(request
					, "endDate"
					, SearchDateUtil.getDay(now, searchVOInSession.getEndSearchDay()));
//		}
//		else {
//			searchStartYear = searchVOInSession.getStartSearchYear();
//			searchStartMonth = searchVOInSession.getStartSearchMonth();
//			searchStartDay = searchVOInSession.getStartSearchDay();
//			
//			searchEndYear = searchVOInSession.getEndSearchYear();
//			searchEndMonth = searchVOInSession.getEndSearchMonth();
//			searchEndDay = searchVOInSession.getEndSearchDay();
//		}
		
		articleSearchVO.setSearchStartDate(searchStartYear
				, searchStartMonth, searchStartDay);
		
		articleSearchVO.setSearchEndDate(searchEndYear
				, searchEndMonth, searchEndDay);
		
		String isSecret = RequestUtil.
				getParam(request, "isSecret", searchVOInSession.getIsSecret());
		articleSearchVO.setIsSecret(isSecret);
		
		String subject = RequestUtil.
				getParam(request, "subject", searchVOInSession.getSubject());
		articleSearchVO.setSubject(subject);
		
		String content = RequestUtil.
				getParam(request, "content", searchVOInSession.getContent());
		articleSearchVO.setContent(content);
		
		String authorKeyword = RequestUtil.
				getParam(request, "authorKeyword", searchVOInSession.getAuthorKeyword());
		String author = RequestUtil.
				getParam(request, "author", searchVOInSession.getAuthor());
		
		if(authorKeyword.length() > 0) {
			articleSearchVO.setAuthor(author);
			articleSearchVO.setAuthorKeyword(authorKeyword);
		}
		
		session.setAttribute("_SEARCH_KEYWORD_", articleSearchVO);
		
		ArticleListVO articleList = 
				this.boardBiz.getList(articleSearchVO);
		
		articleList = this.replyBiz.getReplyCount(articleList);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("articleSearchVO", articleSearchVO);
		
		view.setViewName("board/list");
		view.addObject("articleList", articleList);
		
		return view;
	}

	@Override
	public ModelAndView viewModify(HttpSession session, int articleId) {
		
		ArticleVO originalArticleInfo = this.boardBiz.getArticle(articleId);
		
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String id = userVO.getEmailId();
		
		if( !originalArticleInfo.getEmailId().equals(id) ) {
			throw new RuntimeException("수정 권한이 없습니다.");
		}
		
		String content = originalArticleInfo.getContent();
		content = content.replaceAll("<br/>", "\n");
		originalArticleInfo.setContent(content);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("board/modify");
		view.addObject("originalArticleInfo", originalArticleInfo);
		return view;
	}
	
	@Override
	public ModelAndView modify(HttpServletRequest request, ArticleVO articleVO, Errors errors) {
		
		ArticleVO originalArticleInfo = this.boardBiz.getArticle(articleVO.getArticleId());
		
		HttpSession session  = request.getSession();
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String id = userVO.getEmailId();
		
		if( !originalArticleInfo.getEmailId().equals(id) ) {
			throw new RuntimeException("수정 권한이 없습니다.");
		}
		
		articleVO.setEmailId(id);
		
		this.boardBiz.modify(articleVO);
		ArticleVO updatedArticle = this.boardBiz.getArticle(articleVO.getArticleId());
		HistoryVO historyVO = new HistoryVO();
		historyVO.setEmailId(id);
		historyVO.setIp(request.getRemoteAddr());
		historyVO.setOperationType(OperationHistory.BOARD_HISTORY);
		String message = "글수정 성공 : 제목 : %s -> %s, 내용 : %s -> %s";
		historyVO.setOperationDescription(
				String.format(message
						, articleVO.getSubject()
						, updatedArticle.getSubject()
						, articleVO.getContent()
						, updatedArticle.getContent()));
		this.historyBiz.putHistory(historyVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board/list");
		return view;
	}

	@Override
	public ModelAndView delete(HttpServletRequest request, int articleId) {
		
		HttpSession session = request.getSession();
		UsersVO userVO = (UsersVO) session.getAttribute("_MEMBER_");
		String id = userVO.getEmailId();
		
		ArticleVO articleVO = new ArticleVO();
		articleVO.setArticleId(articleId);
		articleVO.setEmailId(id);
		
		this.boardBiz.delete(articleVO);
		
		HistoryVO historyVO = new HistoryVO();
		historyVO.setEmailId(id);
		historyVO.setIp(request.getRemoteAddr());
		historyVO.setOperationType(OperationHistory.BOARD_HISTORY);
		String message = "글삭제 성공 : 글 번호 : %s";
		historyVO.setOperationDescription(
				String.format(message
						, articleVO.getArticleId()));
		
		this.historyBiz.putHistory(historyVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board/list");
		return view;
	}

	@Override
	public ModelAndView updateHitCount(String id) {
		ModelAndView view = new ModelAndView();
		
		return view;
	}

	@Override
	public ModelAndView updateRecommendCount(String id) {
		ModelAndView view = new ModelAndView();
		
		return view;
	}

}
