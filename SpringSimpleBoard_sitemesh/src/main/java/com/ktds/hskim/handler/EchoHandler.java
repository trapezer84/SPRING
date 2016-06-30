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
import com.ktds.hskim.handler.socket.vo.MessageVO;

public class EchoHandler extends TextWebSocketHandler {
	
	private Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	private PaintDAO paintDAO;
	public void setPaintDAO(PaintDAO paintDAO) {
		this.paintDAO = paintDAO;
	}

	private List<WebSocketSession> connectedUsers;

	private List<String> questions;
	private int questionId = 0;
	
	/**
	 * 서버에 연결한 사용자들 저장
	 */
	public EchoHandler() {
		connectedUsers = new ArrayList<WebSocketSession>();
		questions = new ArrayList<String>();
		questions.add("보노보노");
		questions.add("김치찌개");
		questions.add("나무");
		questions.add("화분");
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
			for (WebSocketSession webSocketSession : connectedUsers) {
				webSocketSession.sendMessage(new TextMessage("자 게임 시작"));
			}
			session.sendMessage(new TextMessage("게임을 시작합니다"));
			
			paintDAO.insertAnswer(questions.get(questionId));
			connectedUsers.get(questionId).sendMessage( new TextMessage( questions.get(questionId)) );
			questionId++;
		}
		
		logger.info(session.getId() + "님 접속");
		logger.info("연결 IP : " + session.getRemoteAddress().getHostName());
		connectedUsers.add(session);
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
		
		// Payload = 사용자가 보낸 메시지
		logger.info(session.getId() + "님이 메시지 전송" + message.getPayload());
		
		MessageVO messageVO = MessageVO.convertMessage(message.getPayload());
		
		String answer = paintDAO.getAnswer();
		if ( answer.equals( messageVO.getMessage()) ) {
			
			paintDAO.deleteAnswer();
			paintDAO.insertAnswer( questions.get(questionId) );
			
			String userName = session.getRemoteAddress().getHostName();
			for (WebSocketSession webSocketSession : connectedUsers) {
				webSocketSession.sendMessage( new TextMessage(userName + "님 정답!" ) );
			}

			connectedUsers.get(questionId).sendMessage( new TextMessage( questions.get(questionId)) );
			questionId++;	
			
			if ( questionId == 4 ) {
				questionId = 0;
			}
			
			return;
		}
		
		String hostName = "";
		for (WebSocketSession webSocketSession : connectedUsers) {
			
			// 전체 전송
			if ( messageVO.getType().equals("all") ) {
				// 보낸 사용자는 받지 않기 위한 조건문
				if ( !session.getId().equals(webSocketSession.getId()) ) {
					webSocketSession.sendMessage( new TextMessage( session.getRemoteAddress().getHostName() + " -> " + messageVO.getMessage() ) );
				}
			}
			// 귓속말 전송
			else {
				hostName = webSocketSession.getRemoteAddress().getHostName();
				
				if ( messageVO.getTo().equals(hostName) ) {
					webSocketSession.sendMessage( new TextMessage( "<span style=/color: red;'>" +  session.getRemoteAddress().getHostName() + " -> " + messageVO.getMessage()  + "</span>") );
					break;
				}
			} // else END
		} // for END
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
		
		for (WebSocketSession webSocketSession : connectedUsers) {
			// 보낸 사용자는 받지 않기 위한 조건문
			if ( !session.getId().equals(webSocketSession.getId()) ) {
				webSocketSession.sendMessage( new TextMessage( session.getRemoteAddress().getHostName() + " 퇴장했습니다") );
			}
		}
	}
	
	
} // Class END
