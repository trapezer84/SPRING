package com.ktds.hskim.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.ktds.hskim.handler.socket.dao.PaintDAO;

public class PaintHandler extends TextWebSocketHandler {
	
	private Logger logger = LoggerFactory.getLogger(PaintHandler.class);
	
	private List<WebSocketSession> connectedUsers;
	
	private int index = 0;
	private String question;
	
	private PaintDAO paintDAO;
	public void setPaintDAO(PaintDAO paintDAO) {
		this.paintDAO = paintDAO;
	}


	/**
	 * 서버에 연결한 사용자들 저장
	 */
	public PaintHandler() {
		connectedUsers = new ArrayList<WebSocketSession>();
		question = "";
	}
	
	
	/**
	 * 접속 관련 Event Method
	 * @param WebSocketSession 접속한 사용자
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		if ( connectedUsers.size() > 4 ) {
			session.close();
			return;
		}		
		
		if ( connectedUsers.size() == 3 ) {
			
			for ( int i = 0; i < connectedUsers.size(); i++ ) {
				if ( i == index ) {
					connectedUsers.get(i).sendMessage( new TextMessage("!@#OK") );
				}
				else {
					connectedUsers.get(i).sendMessage( new TextMessage("!@#NO") );
				}
			}
			
			session.sendMessage(new TextMessage("!@#NO"));
			
			while (true) {
				
				if ( paintDAO.getAnswer() != null && !paintDAO.getAnswer().equals("") ) {
					question = paintDAO.getAnswer();
					break;
				}
			}
			
		}
		
		logger.info(session.getId() + "님 접속");
		logger.info("연결 IP : " + session.getRemoteAddress().getHostName());
		connectedUsers.add(session);
		
		for (WebSocketSession webSocketSession : connectedUsers) {
			webSocketSession.sendMessage( new TextMessage("{ \"mode\" : \"fill\", \"color\" : \"#FFFFFF\" }") );
		}
		
	}
	
	
	/**
	 * 2가지 이벤트 처리
	 * 1. Send : 클라이언트가 서버에게 메시지 보냄
	 * 2. Emit : 서버에 연결되어 있는 클라이언트들에게 메시지 보냄
	 * 
	 * @param WebSocketSession 메시지를 보낸 클라이언트
	 * @param TextMessage 메시지의 내용
	 * 
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		if ( !question.equals( paintDAO.getAnswer() ) ) {
			
			for (WebSocketSession webSocketSession : connectedUsers) {
				webSocketSession.sendMessage( new TextMessage("{ \"mode\" : \"fill\", \"color\" : \"#FFFFFF\" }") );
			}		
			
			index++;
			if ( index == 4) {
				index = 0;
			}
			
			for ( int i = 0; i < connectedUsers.size(); i++ ) {
				if ( i == index ) {
					connectedUsers.get(i).sendMessage( new TextMessage("!@#OK") );
				}
				else {
					connectedUsers.get(i).sendMessage( new TextMessage("!@#NO") );
				}
			}			
			
			return;
		}
		
		for (WebSocketSession webSocketSession : connectedUsers) {
			if ( !webSocketSession.getId().equals(session.getId())) {
				webSocketSession.sendMessage(new TextMessage(message.getPayload()));
			}
		}
		
	}
	
	
	/**
	 * 클라이언트가 서버와 연결 종료
	 * 
	 * @param WebSocketSession 연결을 끊은 클라이언트
	 * @param CloseStatus 연결 상태 (확인 필요)
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info(session.getId() + "님 접속 종료");
		connectedUsers.remove(session);
	}
	
	
} // Class END
