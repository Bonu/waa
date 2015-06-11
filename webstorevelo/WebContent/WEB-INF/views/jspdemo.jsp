<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Velocity List</title>
</head>
<body bgcolor="#E6E6FA">
 
<UL style='list-style-type:none;' />

  	<section>
		<div class="jumbotron">
 
<H1>Select Category</H1>
 
 
	 <h3>Spring JSP Select</h3>
	<form:form action="saveJSP" modelAttribute ="product" >
  
 		 <form:select path="category" items="${categoryMap}" />
		 
		 	 <h3>Regular JSP Select</h3>

      <select name="category">
     
		 <c:forEach var="category" items = "${categoryList}">
		 		<c:choose>
                   <c:when test = "${product.category eq category}"  >
   						 <c:set var="selected" value="selected"></c:set>
   					 </c:when>	 
                    <c:otherwise>
                        <c:set var="selected" value=""></c:set>
		 			</c:otherwise>
		 		</c:choose>
           <option ${selected} value="${category}">${category}</option>
 		</c:forEach>
     </select>
	</form:form>
						<p>
  						<a href="<spring:url value="/welcome" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Welcome
					    </a>
 						<a href="<spring:url value="/demo" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Compare Select
					    </a>

	
 </div>
 </section>	
</body>
</html>
