package com.ktds.mcjang.board.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class ReplyVO {

	private int replyId;
	private int articleId;
	private String memberId;
	private String memberName;
	
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	private String createdDate;
	private String modifiedDate;
	
	private boolean isMyReply;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public boolean getIsMyReply() {
		return isMyReply;
	}
	public boolean isMyReply() {
		return isMyReply;
	}
	public void setIsMyReply(boolean isMyReply) {
		this.isMyReply = isMyReply;
	}
	
	
}
