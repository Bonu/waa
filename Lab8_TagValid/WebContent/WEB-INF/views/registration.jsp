<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<h1>Registration Form</h1>
	<br />
	<p>
	     <form:errors path="*" cssStyle="color : red;" /> 
    </p>
	<form:errors/>
	
	<form:form modelAttribute="newStudent" action="/register" method="post">
		<spring:message code="label.id"/>
		<form:input name="id" path="id" />
		<form:input name="firstName" path="firstName" />
		<form:input name="lastName" path="lastName" />
		<form:input name="email" path="email" />
		<form:input name="gender" path="gender" />
		<form:input name="birthday" path="birthday" />
		<form:input name="phone" path="phone" />
	</form:form>
</body>
</html>