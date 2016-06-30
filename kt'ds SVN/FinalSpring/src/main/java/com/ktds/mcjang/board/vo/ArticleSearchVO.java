package com.ktds.mcjang.board.vo;

import com.ktds.mcjang.common.util.Paging;

public class ArticleSearchVO {

	private Paging paging;

	private String startSearchYear;
	private String startSearchMonth;
	private String startSearchDay;
	
	private String endSearchYear;
	private String endSearchMonth;
	private String endSearchDay;
	
	private String isSecret;
	
	private String content;
	private String subject;
	
	private String author;
	private String authorKeyword;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorKeyword() {
		return authorKeyword;
	}

	public void setAuthorKeyword(String authorKeyword) {
		this.authorKeyword = authorKeyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIsSecret() {
		return isSecret;
	}
	
	public void setIsSecret(String isSecret) {
		this.isSecret = isSecret;
	}

	public void setSearchStartDate(String yyyy, String mm, String dd) {
		setStartSearchYear(yyyy);
		setStartSearchMonth(mm);
		setStartSearchDay(dd);
	}
	
	public void setSearchEndDate(String yyyy, String mm, String dd) {
		setEndSearchYear(yyyy);
		setEndSearchMonth(mm);
		setEndSearchDay(dd);
	}
	
	public String getSearchStartDate() {
		String result = "";
		result += getStartSearchYear();
		result += getStartSearchMonth();
		result += getStartSearchDay();
		System.out.println("getSearchStartDate()");
		System.out.println(result);
		return result;
	}
	
	public String getSearchEndDate() {
		String result = "";
		result += getEndSearchYear();
		result += getEndSearchMonth();
		result += getEndSearchDay();
		System.out.println("getSearchEndDate()");
		System.out.println(result);
		return result;
	}
	
	public String getStartSearchYear() {
		return startSearchYear;
	}

	public void setStartSearchYear(String startSearchYear) {
		this.startSearchYear = startSearchYear;
	}

	public String getStartSearchMonth() {
		return startSearchMonth;
	}

	public void setStartSearchMonth(String startSearchMonth) {
		
		if(startSearchMonth.length() == 1) {
			startSearchMonth = "0" + startSearchMonth;
		}
		
		this.startSearchMonth = startSearchMonth;
	}

	public String getStartSearchDay() {
		return startSearchDay;
	}

	public void setStartSearchDay(String startSearchDay) {
		
		if(startSearchDay.length() == 1) {
			startSearchDay = "0" + startSearchDay;
		}
		
		this.startSearchDay = startSearchDay;
	}

	public String getEndSearchYear() {
		return endSearchYear;
	}

	public void setEndSearchYear(String endSearchYear) {
		this.endSearchYear = endSearchYear;
	}

	public String getEndSearchMonth() {
		return endSearchMonth;
	}

	public void setEndSearchMonth(String endSearchMonth) {
		
		if(endSearchMonth.length() == 1) {
			endSearchMonth = "0" + endSearchMonth;
		}
		
		this.endSearchMonth = endSearchMonth;
	}

	public String getEndSearchDay() {
		return endSearchDay;
	}

	public void setEndSearchDay(String endSearchDay) {
		
		if(endSearchDay.length() == 1) {
			endSearchDay = "0" + endSearchDay;
		}
		
		this.endSearchDay = endSearchDay;
	}

	public Paging getPaging() {
		return paging.getClone();
	}

	public void setPaging(Paging paging) {
		this.paging = paging.getClone();
	}
	
}
