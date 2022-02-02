<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fastcampus.ch2.*" %>
<%
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "남궁성");   
	request.setAttribute("list", new java.util.ArrayList());	
%>
<html>  
	<head>   
		<title>EL</title>   
	</head>  
	<body>
		<!-- 아래 세줄은 같은 코드! -->
		person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
		person.getCar().getColor()=${person.getCar().getColor()} <br>
		person.getCar().getColor()=${person.car.color} <br>  
		  
		<!-- 아래 세줄은 같은 코드! -->
		name=<%=request.getAttribute("name")%> <br>   
		name=${requestScope.name} <br>
		name=${name} <br>
		
		<!-- 아래 세줄은 같은 코드! -->
		id=<%=request.getParameter("id")%> <br>
		id=${pageContext.request.getParameter("id")} <br>
		id=${param.id} <br>
		
		
		"1"+1 = ${"1"+1} <br> <!-- 문자열과 숫자를 더하면 문자열은 숫자로 바뀐다 //2 -->
		"1"+="1" = ${"1"+="1"} <br> <!-- += 을 쓰면 더하기가 된다....헷갈린다 //2 -->
		"2">1 = ${"2">1} <br> <!-- 비교연산자를 써도 문자열은 숫자로 바뀐다 //true -->
		null = ${null}<br> <!-- null을 출력하면 아무것도 안나온다 -->
		null+1 = ${null+1} <br> <!-- 숫자랑 더할 떈 null이 0으로 바뀐다 //1 -->
		null+null = ${null+null} <br> <!-- null끼리 더할 때도 숫자 0으로 바뀐다 //0 -->
		"" + null = ${""+null} <br> <!-- 빈문자도 0으로 바뀌고 null도 0으로 바뀐다 //0 -->
		""-1 = ${""-1} <br> <!-- 빈문자열은 0으로 바뀐다 //-1 -->
		empty null=${empty null} <br> <!-- empty는 비었냐 안비었냐를 확인 비었으면 true반화 //true -->
		empty list=${empty list} <br> <!-- list는 비어있으므로 //true -->
		null==0 = ${null==0} <br> <!-- == 과 eq는 같은 뜻! null은 0이 아니므로 //false -->
		null eq 0 = ${null eq 0} <br> <!-- false -->
		
		<!-- 위에서 name에 남궁성을 넣어놓았다. -->
		<!-- 다양한 비교연산자를 쓸 수 있지만 el에서는 ==, !=를 많이 쓴다. -->
		name == "남궁성"=${name=="남궁성"} <br> <!-- //true -->
		name != "남궁성"=${name!="남궁성"} <br> <!-- //false -->
		name eq "남궁성"=${name eq "남궁성"} <br> <!-- //true -->
		name ne "남궁성"=${name ne "남궁성"} <br> <!-- not equals 이라는 뜻 //false -->
		name.equals("남궁성")=${name.equals("남궁성")} <br> <!-- //true -->
	</body>
</html>