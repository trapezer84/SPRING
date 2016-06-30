package com.ktds.mcjang.board.biz.impl;

import java.util.ArrayList;

import com.ktds.mcjang.board.biz.BoardBiz;
import com.ktds.mcjang.board.dao.BoardDAO;
import com.ktds.mcjang.board.vo.ArticleListVO;
import com.ktds.mcjang.board.vo.ArticleSearchVO;
import com.ktds.mcjang.board.vo.ArticleVO;
import com.ktds.mcjang.common.util.Paging;

public class BoardBizImpl implements BoardBiz {

	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public void write(ArticleVO articleVO) {
		
		String content = articleVO.getContent();
		content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");
		articleVO.setContent(content);
		
		this.boardDAO.write(articleVO);
	}

	@Override
	public ArticleVO getArticle(int id) {
		return this.boardDAO.getArticle(id);
	}

	@Override
	public ArticleListVO getList(ArticleSearchVO articleSearchVO) {
		
		int count = 
				this.boardDAO.getArticleCount(articleSearchVO);
		
		Paging paging = articleSearchVO.getPaging();
		paging.setTotalArticleCount(count);
		
		ArticleListVO list = new ArticleListVO();
		list.setPaging(paging);
		if(count > 0) {
			list.setArticleList(
					this.boardDAO.getList(articleSearchVO));
		}
		else {
			list.setArticleList(new ArrayList<ArticleVO>());
		}
		
		return list;
	}

	@Override
	public void modify(ArticleVO articleVO) {
		
		String content = articleVO.getContent();
		content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");
		articleVO.setContent(content);
		
		ArticleVO originalArticleInfo = this.boardDAO.getArticle(articleVO.getArticleId());
		
		ArticleVO updateArticleInfo = new ArticleVO();
		if( !articleVO.getSubject().equals( originalArticleInfo.getSubject() ) ) {
			updateArticleInfo.setSubject( articleVO.getSubject() );
		}
		if( !articleVO.getContent().equals( originalArticleInfo.getContent() ) ) {
			updateArticleInfo.setContent( articleVO.getContent() );
		}
		if( !articleVO.getIsSecret().equals( originalArticleInfo.getIsSecret() ) ) {
			updateArticleInfo.setIsSecret( articleVO.getIsSecret() );
		}
		updateArticleInfo.setIsSecret(articleVO.getIsSecret());
		updateArticleInfo.setArticleId( articleVO.getArticleId() );
		updateArticleInfo.setEmailId(articleVO.getEmailId());
		this.boardDAO.modify(updateArticleInfo);
	}

	@Override
	public void delete(ArticleVO articleVO) {
		this.boardDAO.delete(articleVO);
	}

	@Override
	public void updateHitCount(String id) {
		this.boardDAO.updateHitCount(id);
	}

	@Override
	public void updateRecommendCount(String id) {
		this.boardDAO.updateRecommendCount(id);
	}

}
