package com.ktds.bhyu.handler.socket.vo;

import com.google.gson.Gson;

public class PointVO {

	private int prevX;
	private int prevY;
	private int nowX;
	private int newY;
	
	public static PointVO getPoint(String source) {
		PointVO point = new PointVO();
		Gson gson = new Gson();
		point = gson.fromJson(source, PointVO.class);
		
		return point;
	}
	
	public int getPrevX() {
		return prevX;
	}
	public void setPrevX(int prevX) {
		this.prevX = prevX;
	}
	public int getPrevY() {
		return prevY;
	}
	public void setPrevY(int prevY) {
		this.prevY = prevY;
	}
	public int getNowX() {
		return nowX;
	}
	public void setNowX(int nowX) {
		this.nowX = nowX;
	}
	public int getNewY() {
		return newY;
	}
	public void setNewY(int newY) {
		this.newY = newY;
	}
	
	
	
}
