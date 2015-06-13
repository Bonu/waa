<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
 	<section>
		<div class="jumbotron">
 
 <H1>Select View Type</H1>
 
 	<section class="container">
		<div class="row">
				<div class="col-md-5">
					<p>
						<a href="<spring:url value="/demo/freemarker" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Freemarker
					    </a>
	
						<a href="<spring:url value="/demo/velocity" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Velocity
					    </a>

						<a href="<spring:url value="/demo/jsp" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> JSP
					    </a>

					</p>    
				</div>
				<br/>
				<p>
  						<a href="<spring:url value="/welcome" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Welcome
					    </a>
				</p> 
		</div>
	</section>
	
	</div>
</section>
</body>
</html>
