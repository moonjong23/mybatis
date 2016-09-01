<%@page import="pack.Student"%>
<%@page import="pack.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전통 : 안녕 <%=request.getAttribute("man") %><br>
EL : 안녕 ${requestScope.man} , ${man}<p>

전통 : <% Person p = (Person)request.getAttribute("person"); %>
		<%=p.getName() %>,
		<%=((Person)request.getAttribute("person")).getName() %>
<br>
EL :${person.name}<p>

전통 : <%Student s =(Student)request.getAttribute("student"); %>
		<%=s.getAge() %>,
		<%=((Student)request.getAttribute("student")).getAge() %>
<br>
EL :${student.age}<p>
<br>
${animal[0]} ${animal[1]} ${animal[2]}
<br>

<br>
<c:if test="${list != null}">
	<c:forEach var="a" items="${list}">
		${a[0]}, ${a[1]}, ${a[2]}
	</c:forEach>
</c:if>
<br>
<c:choose>
	<c:when test="${list eq null}">
		자료 없음
	</c:when>
	<c:otherwise>
		자료 있음
	</c:otherwise>
</c:choose>

<hr>
try ~ except 처리<br>
<c:catch var="myErr">
	<%int a = 10 / 0; out.println(a); %>
</c:catch>
<c:if test="${myErr != null }">
	에러 발생 : ${myErr.message}
</c:if>
<br>
다른 문서 포함(include)<br>
지시어 : <%@ include file="poham.jsp" %>
<br>
jsp action tag사용 : <jsp:include page="poham.jsp"/>
<br>
jstl 사용 : <c:import url="poham.jsp"/>
<br>

<c:import url="http://www.daum.net"/>
<br>
<c:set var="url" value="http://www.naver.com"/>
<c:import url="${url}" var="u"/>
<c:out value="${url }"/>	<!-- http://naver.com라는 주소가 출력 -->
<c:out value="${u }"/>	<!-- 소스 출력 -->
</body>
</html>





