<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE HTML>

<html>
<head>
<title>Add Employee Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">

<div class="pull-right" style="padding-right:50px">
	<a href="?language=en">English</a>|
	<a href="?language=nl">Dutch</a>|
	<a href="?language=te_IN">Telugu</a>
</div>

<form:form commandName="employee" action="employee_save" method="post" enctype="multipart/form-data">

    <fieldset>
        <legend>Add an employee</legend>
  		<p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
        <p>
            <label for="firstName"><spring:message code="emp.firstname.label"/></label>
           <form:input path="firstName" />
 	
 		  	<div style="text-align: center;">
 				<form:errors path="firstName" cssStyle="color : red;" /> 
 			</div>
       </p>
        <p>
            <label for="lastName"><spring:message code="emp.lastname.label"/></label>
           <form:input path="lastName" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="lastName" cssStyle="color : red;" /> 
 			</div>
       </p>

        <p>
            <label for="birthDate"><spring:message code="emp.birthdate.label"/></label>
            <form:input path="birthDate" id="birthDate" />
 			<form:errors path="birthDate" cssStyle="color : red;" /> 
        </p>
        <p>
            <label for="id"><spring:message code="emp.id.label"/></label>
            <form:input path="id" id="id" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="id" cssStyle="color : red;" /> 
 			</div>
       </p>
    <h4>Address:</h4>
        <p>
            <label for="street"><spring:message code="emp.address.street.label"/></label>
            <form:input path="address.street" id="street" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="address.street" cssStyle="color : red;" /> 
 			</div>
       </p>
        <p>
            <label for="state"><spring:message code="emp.address.state.label"/></label>
            <form:input path="address.state" id="state" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="address.state" cssStyle="color : red; " /> 
 			</div>
       </p>
        <p>
            <label for="zipCode"><spring:message code="emp.address.zipcode.label"/></label>
            <form:input path="address.zipCode" id="zipCode" />
 	
 		  	<div style="text-align: center;">
 				<form:errors path="address.zipCode" cssStyle="color : red; " /> 
 			</div>
       </p>
       <p>	
       		<label for="employeeImage"><spring:message code="emp.image.label"/></label>
       	    <form:input id="employeeImage" path="employeeImage" type="file" class="form:input-large" />
       <p>
       	
       </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Employee">
        </p>
        
        
    </fieldset>
</form:form>
</div>
</body>
</html>
