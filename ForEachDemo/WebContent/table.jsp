<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<table>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lecture 5</title>
</head>
<body>
<table>
 
	<c:forEach var="student" items="${students}">
		<tr>
		<c:if test="${student.name eq 'bob'}">
   				<td><b>${student.name}</b></td>
		</c:if>
		<c:if test="${student.name ne 'bob'}">
			<td>${student.name}</td>
		</c:if>
			<td>${student.age}</td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>
 
