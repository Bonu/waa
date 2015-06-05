<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>

</head>
<body>

	<h1>Registration Form</h1>
	<br />
	<form:form modelAttribute="student" action="registration" method="post">
	<table>
		<tr><td><form:errors path="*"  cssStyle="color : red;" /></td></tr>
		<tr><td><label for="studentId"> <spring:message code="student.id.label"/> </label>
		<form:input id="studentId" path="studentId" /><br /><form:errors path="studentId"  cssStyle="color : red;" /></td></tr>
		<tr><td><label for="firstName"> <spring:message code="student.firstname.label"/> </label>
		<form:input id="firstName" path="firstName" /><br /><form:errors path="firstName"  cssStyle="color : red;" /></td></tr>
		<tr><td><label for="lastName"> <spring:message code="student.lastname.label"/> </label>
		<form:input id="lastName" path="lastName" /><br /><form:errors path="lastName"  cssStyle="color : red;" /></td></tr>
		<tr><td><label for="email"> <spring:message code="student.email.label"/> </label>
		<form:input id="email" path="email" /><br /><form:errors path="email"  cssStyle="color : red;" /></td></tr>
		<tr><td><label for="gender"> <spring:message code="student.gender.label"/> </label>
		<form:select id="gender" path="gender">
			<form:option value="">Select Gender</form:option>
			<form:option value="MALE">Male</form:option>
			<form:option value="FEMALE">Female</form:option>
		</form:select>
		<br /><form:errors path="gender"  cssStyle="color : red;" /></td></tr>
		<tr><td><label for="birthday"> <spring:message code="student.birthday.label"/> </label>
		<form:input id="birthday" path="birthday" /><br /><form:errors path="birthday"  cssStyle="color : red;" /></td></tr>
		<tr><td><label for="phone"> <spring:message code="student.phone.label"/> </label>
		<form:input id="phone.area" path="phone.area" />
		<form:input id="phone.prefix" path="phone.prefix" />
		<form:input id="phone.number" path="phone.number" /><br />
		
		<form:errors path="phone.area"  cssStyle="color : red;" />
		<form:errors path="phone.prefix"  cssStyle="color : red;" />
		<form:errors path="phone.number"  cssStyle="color : red;" />
		</td></tr>
		<tr><td><input type="submit" value="Add Student"/></td></tr>
		</table>
	</form:form>
</body>
</html>