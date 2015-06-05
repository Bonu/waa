<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<title>User</title>
</head>
<body>

	<h1>User Form</h1>
	<br />
	
	<form:form modelAttribute="user" action="saveuser" method="post">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<fieldset>
			<label for="id"> Id: </label>
			<form:input id="userId" path="userId" /><br />
			<label for="firstName"> Name: </label>
			<form:input id="name" path="name" /><br />
			<input type="submit" value="AddUser"/>
		</fieldset>
	</form:form>
</body>
</html>