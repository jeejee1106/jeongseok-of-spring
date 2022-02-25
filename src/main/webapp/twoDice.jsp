<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Random" %>
<%-- <%! 클래스 영역 %> --%>
<%!  
	int getRandomInt(int range){
		return new Random().nextInt(range)+1;
	}
%>
<%-- <%  메서드 영역 - service()의 내부 %> --%>
<%
	int idx1 = getRandomInt(6);
	int idx2 = getRandomInt(6);
%>
<html>
<head>
	<title>twoDice.jsp</title>
</head>
<body>
	<%-- jsp페이지는 따로 WebServlet에서 매핑할 필요가 없다.(자동으로 매핑이 됨.) 주소창에 twoDice.jsp를 입력하면 호출이 된다... 뭐지...? --%>
	<%-- WEB-INF아래에 있는 jsp파일들은 매핑을 안해줘도 주소창에 *.jsp를 입력하면 호출이 되는 것 같다. --%>
	<img src='resources/img/dice<%=idx1%>.jpg'>
	<img src='resources/img/dice<%=idx2%>.jpg'>
</body>
</html>