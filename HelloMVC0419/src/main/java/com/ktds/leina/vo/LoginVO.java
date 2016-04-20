package com.ktds.leina.vo;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class LoginVO {

	@NotEmpty(message="ID는 필수 입력 값입니다.")
	private String id;
	@NotEmpty(message="Password는 필수 입력 값 입니다.")
	private String password;
	@Min(value=10, message="최소 10입니다.")
	@Max(value=50, message="최대 50입니다")
	private int memberNumber; 
	private boolean enableAutoLogin;
	private List<String> hobby;
	
	private MultipartFile uploadFile;
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	public boolean isEnableAutoLogin() {
		return enableAutoLogin;
	}
	public void setEnableAutoLogin(boolean enableAutoLogin) {
		this.enableAutoLogin = enableAutoLogin;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
