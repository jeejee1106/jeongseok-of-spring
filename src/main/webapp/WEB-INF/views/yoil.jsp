<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>YoliTellerMVC</title>
	</head>
	<body>
		<h3>RequestParamTest 매개변수 받기</h3>
		<h4>> year=<%=request.getParameter("year") %></h4>
		<br>
		<h3>YoilTellerMVC1,2 매개변수 받기</h3>
		<h4>> ${year}년 ${month}월 ${day}일은 ${yoil}요일 입니다. </h4>
		<br>
		<h3>YoilTellerMVC4,5,6 매개변수 받기</h3>
		<h4>> ${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일 입니다. </h4>
	</body>
</html>
