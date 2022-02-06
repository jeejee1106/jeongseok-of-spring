<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>id=${param.id}</h1>
		<h1>pwd=${param.pwd}</h1>
		<h1>name=${param.name}</h1>
		<h1>email=${param.email}</h1>
		<h1>birth=${param.birth}</h1>
		<!-- registerForm.html에서 보내는 name값이 모두 sns이다. 즉 같은 name값이 여러개이다. -->
		<!-- 그럴 떈 paramValues라는 배열에 담아서 출력해주어야 한다. -->
		<h1>sns=${paramValues.sns[0]}</h1>
		<h1>sns=${paramValues.sns[1]}</h1>
		<h1>sns=${paramValues.sns[2]}</h1>
	</body>
</html>