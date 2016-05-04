package com.ktds.leina.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.ktds.leina.handler.socket.dao.PaintDAO;
import com.ktds.leina.handler.socket.vo.MessageVO;

public class EcoHandler extends TextWebSocketHandler {

	private Logger logger = LoggerFactory.getLogger(EcoHandler.class);

	private PaintDAO paintDAO;

	public void setPaintDAO(PaintDAO paintDAO) {
		this.paintDAO = paintDAO;
	}

	private List<WebSocketSession> connectedUsers;
	private List<String> questions;
	private int questionId;

	public EcoHandler() {
		connectedUsers = new ArrayList<WebSocketSession>();
		questions = new ArrayList<String>();
		questions.add("장독대");
		questions.add("시계");
		questions.add("말타기");
		questions.add("양궁");
	}

	/**
	 * 접속과 관련되어있는 Event Method
	 * 
	 * @param WebsocketSession
	 *            접속한 사용자
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 4명만 접속할 수 있게 한다.
		if (connectedUsers.size() > 4) {
			session.close();
			return;
		}

		// 내가 4번째로 접속했을 때
		if (connectedUsers.size() == 3) {
			for (WebSocketSession webSocketSession : connectedUsers) {
				webSocketSession.sendMessage(new TextMessage("게임을 시작합니다."));
			}
			// session은 나
			// webSocketSession 은 다른 사람
			session.sendMessage(new TextMessage("게임을 시작합니다."));

			paintDAO.inserAnswer(questions.get(questionId));
			// 문제를 전달
			connectedUsers.get(questionId).sendMessage(new TextMessage(questions.get(questionId)));
			questionId++;
		}

		connectedUsers.add(session);
		logger.info(session.getId() + "님이 접속했습니다.");
		logger.info("연결 IP : " + session.getRemoteAddress().getHostName());
	}

	/**
	 * 두 가지 이벤트를 처리함 1. send : 클라이언트가 서버에게 메시지를 보냄 2. Emit : 서버에 연결되어 있는
	 * 클라이언트들에게 메시지를 보냄
	 * 
	 * @param WebsocketSession
	 *            메시지를 보낸 클라이언트
	 * @param TextMessage
	 *            메세지의 내용
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		MessageVO messageVO = MessageVO.convertMessage(message.getPayload());

		String answer = paintDAO.getAnswer();
		if (answer.equals(messageVO.getMessage())) {
			paintDAO.deleteAnswer();
			paintDAO.inserAnswer(questions.get(questionId));

			String userName = session.getRemoteAddress().getHostName();
			for (WebSocketSession webSocketSession : connectedUsers) {
				webSocketSession.sendMessage(new TextMessage(userName + "이 정답을 맞추었습니다! ★☆축하합니다★☆"));
			}
			// 문제를 전달
			connectedUsers.get(questionId).sendMessage(new TextMessage(questions.get(questionId)));
			questionId++;
			
			if(questionId == 4) {
				questionId = 0;
			}
			
			return;
		}
		String hostName = "";

		for (WebSocketSession webSocketSession : connectedUsers) {
			// 전체 전송
			if (messageVO.getType().equals("all")) {
				if (!session.getId().equals(webSocketSession.getId())) {
					// 사용자가 보냈던 메세지를 다른 사용자에게 보내주는 것
					// 누가 메세지를 보냈는지 함께 적어준다.
					webSocketSession.sendMessage(
							new TextMessage(session.getRemoteAddress().getHostName() + " → " + messageVO.getMessage()));
				}
			}
			// 귓속말
			else {
				hostName = webSocketSession.getRemoteAddress().getHostName();
				if (messageVO.getTo().equals(hostName)) {
					webSocketSession.sendMessage(new TextMessage("<span style='color:red;'> "
							+ session.getRemoteAddress().getHostName() + " → " + messageVO.getMessage() + "</span>"));
					break;
				}

			}
		}

		/*
		 * payload : 사용자가 보낸 메세지
		 */
		logger.info(session.getId() + "님이 메세지를 보냈습니다 : " + message.getPayload());
	}

	/**
	 * 클라이언트가 서버와 연결을 끊음
	 * 
	 * @param WebSocketSession
	 *            연결을 끊은 클라이언트
	 * @param CloseStatus
	 *            연결 상태 (확인 필요함...)
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		connectedUsers.remove(session);
		for (WebSocketSession webSocketSession : connectedUsers) {
			// 내가 보낸 메세지인지 아닌지를 체크
			if (!session.getId().equals(webSocketSession.getId())) {
				// 사용자가 보냈던 메세지를 다른 사용자에게 보내주는 것
				webSocketSession.sendMessage(new TextMessage(session.getRemoteAddress().getHostName() + " 퇴장했습니다."));
			}
		}
		logger.info(session.getId() + "님이 퇴장했습니다.");
	}

}
