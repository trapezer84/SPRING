<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/board/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="/board/js/sockjs-1.0.3.min.js"></script>
<script type="text/javascript">

	var chatSock = null;
	var message = {};

	$(document).ready(function() {
		
		$("#message").keyup( function(e) {
			if ( e.keyCode == 13 ) {
				
				$("#sendMessage").click();
			}
		}) ;
		
		chatSock = new SockJS("/board/echo-ws");
		chatSock.onopen = function() {
			message = {};
			message.message = "반갑습니다!";
			message.type = "all";
			message.to = "all";
			
			chatSock.send( JSON.stringify(message) );
		}
		
		chatSock.onmessage = function(evt) {
			//alert(evt.data);
			$("#chatMessage").append(evt.data + "<br/>");
			$("#chatMessage").scrollTop(999999999);
		}
		
		chatSock.onclose = function() {
			//sock.send("10.225.152.165 퇴장");
		}
		
		$("#sendMessage").click(function() {
			if ( $("#message").val() != "" ) {
				
				message = {};
				message.message = $("#message").val();
				message.type = "all";
				message.to = "all";
				
				var to = $("#to").val();
				if ( to != "" ) {
					message.type = "one";
					message.to = to;
				}
				
				chatSock.send( JSON.stringify(message) );
				$("#chatMessage").append("나 -> " + $("#message").val() + "<br/>");
				$("#chatMessage").scrollTop(999999999);
				
				$("#message").val("");
			}
		});
	
	});

</script>
</head>
<body>
	<input type="text" id="to" />
	<input type="text" id="message" autoFocus />
	<input type="button" id="sendMessage" value="보내기" />
	
	<div id="chatMessage" style="overFlow: auto; max-height: 500px;"></div>	
	
</body>
</html>


