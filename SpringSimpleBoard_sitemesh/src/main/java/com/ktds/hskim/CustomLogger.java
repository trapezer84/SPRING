package com.ktds.hskim;

import org.slf4j.Logger;

public abstract class CustomLogger {
	
	// protected는 상속 관계에서만 사용 가능 
	// (default) 아무것도 없는 것은 같은 패키지 안에서 사용 가능 
	protected Logger logger;
	
	public CustomLogger(Logger logger) {
		this.logger = logger;
	}
	
	public void trace(String msg) {
		logger.trace(msg);
		writeTrace(msg);
	}
	
	public void debug(String msg) {
		logger.debug(msg);
		writeDebug(msg);
	}
	
	public void info(String msg) {
		logger.info(msg);
		writeInfo(msg);
	}
	
	public void warm(String msg) {
		logger.warn(msg);
		writeWarm(msg);
	}
	
	public void error(String msg) {
		logger.error(msg);
		writeError(msg);
	}
	
	protected abstract void writeTrace(String msg);
	protected abstract void writeDebug(String msg);
	protected abstract void writeInfo(String msg);
	protected abstract void writeWarm(String msg);
	protected abstract void writeError(String msg);

}
