package com.ktds.bhyu.handler.socket.vo;

public class Answer {

	private String answer;
	private String ip;
	
	public Answer(String answer, String ip) {
		this.answer = answer;
		this.ip = ip;
	}
	
	public Answer() {
	}

	public String getAnswer() {
		return answer == null ? "" : this.answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getIp() {
		return ip == null ? "" : this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
