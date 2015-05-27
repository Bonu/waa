<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Starbuck's</title>
</head>
<body>
<h2>Display advice about your favorite roast: <%= request.getAttribute("roast") %></h2>
	<table>
 		<c:forEach var="item" items="${advice}">
		<tr><td><c:out value ="${item}"/></td></tr>
		</c:forEach>
	</table>
</body>
</html>
