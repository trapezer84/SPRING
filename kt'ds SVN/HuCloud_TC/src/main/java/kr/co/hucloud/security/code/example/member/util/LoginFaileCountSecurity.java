package kr.co.hucloud.security.code.example.member.util;

public class LoginFaileCountSecurity {

	private int loginFaileCount;
	private long latestLoginFailTimeMillis;
	
	public int getLoginFailCount() {
		return loginFaileCount;
	}
	public void addLoginFailCount() {
		this.loginFaileCount++;
	}
	
	public long getLatestLoginFailTimeMillis() {
		return latestLoginFailTimeMillis;
	}
	public void setLatestFailTimeMillis() {
		this.latestLoginFailTimeMillis = System.currentTimeMillis();
	}
	
	public boolean isExceedValidLoginFailCount() {
		return this.loginFaileCount >= 3;
	}
	
	public boolean isInTime60Seconds() {
		long inTime = System.currentTimeMillis() - this.latestLoginFailTimeMillis;
		return (inTime / 1000) < 60;
	}
	
	public void resetLoginFailCount() {
		this.loginFaileCount = 0;
		this.latestLoginFailTimeMillis = 0;
	}
	
}
