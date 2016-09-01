<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
EL 맞이하기<p/>
<%if(request.getParameter("user") == null){%>
	<jsp:forward page="el.html"/>	<!-- 서버에서 서버로 부른거(forward방식) -->
<%}%>
표현식 <%=request.getParameter("user") %><br/>
EL 사용 : ${param.user}
</body>
</html>