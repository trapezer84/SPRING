package kr.co.hucloud.utilities.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionStore {

	public static final int ADD_SUCCESS = 0;
	public static final int REMOVE_SUCCESS = 1;
	public static final int ALREADY_EXISTS = -1;
	public static final int SESSION_NOT_EXISTS = -2;
	
	private volatile static Map<String, HttpSession> sessions;
	
	static {
		sessions = new HashMap<String, HttpSession>();
	}
	
	public synchronized static int addSession(String userId, HttpSession session) {
		if ( !isExistsSession(userId) ) {
			sessions.put(userId, session);
			return ADD_SUCCESS;
		}
		return ALREADY_EXISTS;
	}
	
	public synchronized static HttpSession getSession(String userId) {
		if ( isExistsSession(userId) ) {
			return sessions.get(userId);
		}
		return null;
	}
	
	public synchronized static int removeSession(String userId) {
		if ( isExistsSession(userId) ) {
			sessions.remove(userId);
			return REMOVE_SUCCESS;
		}
		return SESSION_NOT_EXISTS;
	}
	
	public synchronized static boolean isExistsSession(String userId) {
		return sessions.containsKey(userId);
	}
	
	public synchronized static int getSessionSize() {
		return sessions.size();
	}
	
	
}
