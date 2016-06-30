package com.ktds.mcjang.login.vo;

public class UsersVO implements Cloneable {

	private String emailId;
	private String password;
	private String userName;
	private String registeredDate;
	private String modifiedDate;
	private String deleteFlag;
	private String salt;
	private int point;
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public UsersVO getClone() {
		UsersVO temp = new UsersVO();
		
		try {
			temp = (UsersVO) this.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return temp;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		UsersVO userVO = new UsersVO();
		userVO.setDeleteFlag(deleteFlag);
		userVO.setEmailId(emailId);
		userVO.setModifiedDate(modifiedDate);
		userVO.setPassword(password);
		userVO.setRegisteredDate(registeredDate);
		userVO.setSalt(salt);
		userVO.setUserName(userName);
		
		return userVO;
	}
	
}
