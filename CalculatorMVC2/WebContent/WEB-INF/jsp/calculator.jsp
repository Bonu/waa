<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Calculator</title>
		<style type="text/css">@import url(css/main.css);</style>
	</head>
	
	<body>
		<div id="global">
		<c:if test="${errors != null}">
		     <p id="errors">
		         Error(s)!
		        <ul>
			        <c:forEach var="error" items="${errors}">
			            <li>${error}</li>
			        </c:forEach>
			    </ul>
		 </c:if>
		<form action="calculator_result" method="post">
			<input type="text" name="add1" size="2" value="${form.add1}" />+ <input
			type="text" name="add2" value="${form.add2}" size="2" />= <input
			type="text" name="sum" value="${form.sum}" size="2" readonly /><br /> <input
			type="text" name="prd1" value="${form.prd1}" size="2" />* <input
			type="text" name="prd2" value="${form.prd2}" size="2" />= <input
			type="text" name="product" value="${form.product}" size="2" readonly /><br />
			<input type="submit" value="Submit" />
		</form>
		</div>
	</body>
</html>