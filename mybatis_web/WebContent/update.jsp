<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="processDao" class="pack.business.ProcessDao"></jsp:useBean>
    <%String code = request.getParameter("code");
    	DataDto dto = processDao.selectDataPart(code);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
* 상품 수정 **<p/>
<form action="updateok.jsp" method="post">
<input type="hidden" name="code" value="<%= dto.getCode() %>" >
코드 : <%=dto.getCode() %>
품명 : <input type="text" name="sang" value="<%= dto.getSang() %>"><br>
수량 : <input type="text" name="su" value="<%= dto.getSu() %>"><br>
단가 : <input type="text" name="dan" value="<%= dto.getDan() %>"><br>
<input type="submit" value="수정">
</form>
</body>
</html>