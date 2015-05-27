<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Starbuck's</title>
	</head>
	<body>
		<h2>Home Page</h2>
		<p />
		<h4>The Random Numbers are:</h4>
		<table>
		<tr><td><%= request.getAttribute("rn1") %></td></tr>
		<tr><td><%= request.getAttribute("rn2") %></td></tr>
		<tr><td><%= request.getAttribute("rn3") %></td></tr>
		<tr><td><%= request.getAttribute("rn4") %></td></tr>
		</table>
		<c:set var="number1" value="${rn1}"/>
		<c:set var="number2" value="${rn2}"/>
		<c:set var="number3" value="${rn3}"/>
		<c:set var="number3" value="${rn4}"/>
		<c:choose>
		 <c:when test="${number1 == number2}">
		     ${"number1 is Equal to number2"}
		 </c:when>
		 <c:when test="${number1 > number3}">
		     ${"number1 is greater than number3"}
		 </c:when>
		 <c:when test="${number1 < number4}">
		     ${"number1 is less than equal to number2"}
		 </c:when>
		 
		</c:choose>
		
	</body>
</html>