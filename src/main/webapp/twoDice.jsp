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
	<%-- 이 파일은 매핑이 없어도 주소창에 twoDice.jsp를 입력하면 호출이 된다... 뭐지...? --%>
	<img src='resources/img/dice<%=idx1%>.jpg'>
	<img src='resources/img/dice<%=idx2%>.jpg'>
</body>
</html>