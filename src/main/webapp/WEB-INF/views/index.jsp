<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> <!-- 이 페이지에서는 세션을 시작(생성)하지 않겠다! -->
<!-- session="false"일 때 sessionScope는 사용불가.
	 sessionScope.id를 pageContext.request.session.getAttribute("id") 로 변경해야한다.-->
<c:set var="loginOutLink" value="${pageContext.request.session.getAttribute('id')==null ? '/login/login' : 'login/logout'}"/>
<c:set var="loginOut" value="${pageContext.request.session.getAttribute('id')==null ? 'Login' : 'Logout'}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>fastcampus</title>
	    <link rel="stylesheet" href="<c:url value='resources/css/menu.css'/>">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>    
	</head>
	<body>
		<div id="menu">
			<ul>
			    <li id="logo">fastcampus</li>
			    <li><a href="<c:url value='/'/>">Home</a></li>
			    <li><a href="<c:url value='/board/list'/>">Board</a></li>
			    <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
			    <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
			    <li><a href=""><i class="fas fa-search small"></i></a></li>
			</ul> 
		</div>
		<div style="text-align:center">
			<h1>This is HOME</h1>
			<h1>This is HOME</h1>
			<h1>This is HOME</h1>
		</div>
	</body>
</html>