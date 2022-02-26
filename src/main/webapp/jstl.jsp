<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>JSTL</title>
	</head>
	<body>
		<c:set var="to"   value="10"/> <!-- to 라는 변수에 10을 저장한 것. scope="page"가 생략됨. -->
		<c:set var="arr"  value="10,20,30,40,50,60,70"/> <!-- 배열은 이렇게 만듬! -->
		
		<c:forEach var="i" begin="1" end="${to}"> <!-- jstl에서의 for문. 선언한 변수는 el태그로! -->
			${i}
		</c:forEach>
		
		<br>
		
		<c:if test="${not empty arr}"> <!-- jstl에서의 if문. test에 조건문을 적어준다.(배열이 비어있지 않으면) -->
			<c:forEach var="elem" items="${arr}" varStatus="status"> <!-- varStatus는 count(1~)와 index(0~)가 있다. -->
				${status.count}. arr[${status.index}]=${elem}<BR>
			</c:forEach>
		</c:if>	
		
		<c:if test="${param.msg != null}">
			msg=${param.msg} <!-- 이렇게 출력하면 주소창에 태그를 썼을 때 태그가 인식되어 html형식으로 나온다. -->
			msg=<c:out value="${param.msg}"/> <!-- out을 써주면 주소창에 태그를 써줘도 태그로 인식을 안한다. -->
			<!-- http://localhost:9000/ch2/jstl.jsp?msg=<b>안녕하세요</b> 입력해보기!!!! -->
		</c:if>
		
		<br>
		
		<c:if test="${param.msg == null}">메시지가 없습니다.<br></c:if>
		
		<c:set var="age" value="${param.age}"/>
		<!-- if-else문 -->
		<c:choose>
			<c:when test="${age >= 19}">성인입니다.</c:when>
			<c:when test="${0 <= age && age < 19}">성인이 아닙니다.</c:when>
			<c:otherwise>값이 유효하지 않습니다.</c:otherwise>
		</c:choose>
		
		<br>
		
		<c:set var="now" value="<%=new java.util.Date() %>"/>
		Server time is <fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd HH:mm:ss"/>	
	</body>
</html>