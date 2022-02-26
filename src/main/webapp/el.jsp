<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fastcampus.ch2.*" %>
<%
	Person person = new Person(); //person은 지역변수인데, el태그는 이 지역변수를 바로 쓸 수 없다.
	request.setAttribute("person", person); //이렇게 request객체에 저장을 해주어야 사용할 수 있다.
	request.setAttribute("name", "김성규");   
	request.setAttribute("list", new java.util.ArrayList());	
%>
<!-- 처음 이 파일을 호출하면 시간이 조금 걸린다. 그 후 새로 고침을 누르면 바로바로 리로드가 된다.
	 그 이유는 jsp가 java파일로 변환되고 컴파일 되는 시간이 걸리기 때문이다. 
	 이클립스 워크스페이스\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\프로젝트파일명\org\apache\jsp" 
	 위 경로를 따라가면 jsp가 .java와 .class 파일로 변경되어 저장된 위치를 알 수 있다. jsp가 .java파일로 변경된 파일을 열어보면 servlet형식으로 쓰여져 있는 것을 확인할 수 있다.
	 -->
<html>  
	<head>   
		<title>EL</title>   
	</head>  
	<body>
		<!-- 아래 세줄은 같은 코드! 1,2번 처럼 쓸 수도 있지만, 간편함을 위해 3번 코드처럼 쓴다. (el태그의 장점 간편하다.)-->
		person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
		person.getCar().getColor()=${person.getCar().getColor()} <br>
		person.getCar().getColor()=${person.car.color} <br>  
		  
		<!-- 아래 세줄은 같은 코드! -->
		name=<%=request.getAttribute("name")%> <br>   
		name=${requestScope.name} <br>
		name=${name} <br> <!-- requestScope는 생략가능하다. 생략하면 좁은 범위의 저장소부터 순서대로 찾아본다.-->
		
		<!-- 아래 세줄은 같은 코드! -->
		id=<%=request.getParameter("id")%> <br>
		id=${pageContext.request.getParameter("id")} <br> <!-- el은 null을 출력하지 않기 때문에 빈칸이 출력된다. -->
		id=${param.id} <br>
		
		
		"1"+1 = ${"1"+1} <br> <!-- 문자열과 숫자를 더하면 문자열은 숫자로 바뀐다 //2 -->
		"1"+="1" = ${"1"+="1"} <br> <!-- += 을 쓰면 더하기가 된다....헷갈린다 //11 -->
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
		name == "김성규"=${name=="김성규"} <br> <!-- //true -->
		name != "김성규"=${name!="김성규"} <br> <!-- //false -->
		name eq "김성규"=${name eq "김성규"} <br> <!-- //true -->
		name ne "김성규"=${name ne "김성규"} <br> <!-- not equals 이라는 뜻 //false -->
		name.equals("김성규")=${name.equals("김성규")} <br> <!-- //true -->
	</body>
</html>