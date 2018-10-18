<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>

<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="panel panel-default">

			<div class="panel-body">11111111111 ${user.userName}</div>
		</div>
	</div>
</body>
</html>