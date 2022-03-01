<%@ page contentType="text/html;charset=utf-8" isErrorPage="true"%> <!-- 에러가 났을 때 보여지는 페이지라는  뜻 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>error.jsp</title>
</head>
<body>
<h1>예외가 발생했습니다.</h1>
<!-- 위 isErrorPage="true"를 작성하면 컨크롤러에서 예외를 view로 전달하지 않아도 되며, 기본객체를 쓸 수 있다. -->
<!-- exception이라는 기본 객체를 쓰려면 문법적으로 pageContext. 을 써줘야한다 -->
발생한 예외 : ${pageContext.exception}<br> 
예외 메시지 : ${pageContext.exception.message}<br>
<ol>
<c:forEach items="${pageContext.exception.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>