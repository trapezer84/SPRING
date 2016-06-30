package com.ktds.mcjang.history.vo;

public class HistorySearchVO {

	private int startNumber;
	private int endNumber;
	
	public HistorySearchVO() {
		this(1, 10);
	}

	public HistorySearchVO(int startNumber, int endNumber) {
		this.startNumber = startNumber;
		this.endNumber = endNumber;
	}
	
	public int getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public int getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}
	
}
