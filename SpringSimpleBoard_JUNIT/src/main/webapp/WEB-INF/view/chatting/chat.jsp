<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/board/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/board/js/sockjs-1.0.3.min.js"></script>
<script type="text/javascript" src="/board/js/json2.js"></script>
<script type="text/javascript">
	var chat = null;
	
	$(document).ready(function() {
		// 페이지가 열림과 동시에 소켓과 연결한다는 의미
		chat = new SockJS("/board/echo-ws");
		// 소켓을 열 때 무엇인가를 해라 
		chat.onopen = function() {
			//message 초기화
			message = {};
			
			message.message = "반갑습니다!";
			message.type = "전체에게";
			message.to = "전체에게";
			
			// 메세지를 보내라. 이게 Json으로 바뀌어서 전달됨! 
			chat.send( JSON.stringify(message) );
		};
		chat.onmessage = function(evt) {
			//alert(evt.data);
			$("#chatMessage").append(evt.data + "<br/>");
			$("#chatMessage").scrollTop(99999999);
		};
		chat.onclose = function() {
			//chat.send("10.225.152.184 퇴장 :)")
		}
		
		$("#sendMessage").click(function() {
			if($("#message").val() != "") {
				
				//message 초기화
				message = {};
				
				message.message =  $("#message").val();
				message.type = "all";
				message.to = "all";
				
				var to = $("#to").val();
				// to에 무엇인가 작성되었다면 
				if (to != "") {
					message.type="one";
					message.to = to;
				}
				
				chat.send( JSON.stringify(message) );
				$("#chatMessage").append("<b>나</b>→" + $("#message").val() + " <br/>");
				// 스크롤의 위치를 가장 밑으로 보내버리는 코드
				$("#chatMessage").scrollTop(99999999);
				
				// message 초기화
				$("#message").val("");
			}
		})
	});
</script>
</head>
<body>
	<table style="margin: auto; width:100%;">
		<tr >
			<th colspan="2" style="background-color: #333333; color: white;">안녕하세요~ 기연이네 채팅창입니다.</th>
		</tr>
		<tr>
			<td style="background-color: pink; color: white;">
				귓속말 하기
			</td>
			<td style="background-color: pink; color: white;">
				<input type="text" id="to" tabindex="1" placeholder="누구에게?" style="width:100%; height:100%;"/> <br/>
			</td>
		</tr>
		<tr>
			<td style="background-color: pink; color: white;">
				메세지
			</td>
			<td style="background-color: pink; color: white;">
				<input type="text" id="message" tabindex="2" placeholder="메세지 내용?" style="width:100%; height:100%;" />
			</td>
		</tr>
		<tr>
			<td colspan="2" style="background-color: pink; color: white;">
				<input type="button" id="sendMessage" value="메세지 보내기" tabindex="3" style="width:100%; height:100%;"/>
			</td>
		</tr>
	</table>

	
	
	
	<div id="chatMessage" style="overflow: auto; max-height: 500px; margin: auto;"></div>
	
</body>
</html>