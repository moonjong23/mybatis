<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	isELIgnored="false"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL test</title>
</head>
<body>
---연산자---<br>
\${3 + 4} --> ${3 + 4}<br>
\${5 / 4} --> ${5 / 4}<!-- ${5 div 4} --><br>
\${5 / 0} --> ${5 / 0}<br>
\${5 % 3} --> ${5 % 3}<!--  ${5 mod 3 }도 가능 eclipse가 못알아듣는것뿐 --><br>

\${5 > 3?10:20} --> ${5 > 3?10:20} <!-- 5가3보다 크면 10(3항연산자) --><br>

\${5 > 3} --> ${5 > 3}<!-- ${5 gt 3}, lt,le.. 있음 --><br>
\${5 >= 3 and 4 < 2} --> ${5 >= 3 and 4 < 2}<br><!-- 동시만족이어야 true -->

<p>---내장객체---<br>
<%
request.setAttribute("aa", "air");
session.setAttribute("bb", "book");
application.setAttribute("cc", "cat");
%>
<%=request.getAttribute("aa") %> ${requestScope.aa }<br>
<%=session.getAttribute("bb") %> ${sessionScope.bb }<br>
<%=application.getAttribute("cc") %> ${applicationScope.cc }<br>
<br>
jsp내장객체 : <%=request.getHeader("host") %><br>
EL내장객체 : ${header.host}혹은 ${header["host"]}
<p>---collection 객체 처리---<br>
<%
ArrayList list = new ArrayList();
list.add("kor");
list.add("eng");
request.setAttribute("list", list);
%>
${list[0]}, ${list["1"]}

<p>---client 자료 읽기---<br>
<a href="eltest.html">html call</a><br>
이름 : ${param.irum}, ${param["irum"]}<br>
성격 : ${param.sung}, ${param["sung"]}<br>
${paramValues.sung[0]}, ${paramValues.sung[1]}
</body>
</html>