<#import "spring.ftl" as spring />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
			</div>
		</div>
	</section>
		<section class="container">
		<div class="row">
				<div class="col-md-5">
					<p>
						<a href="<@spring.url  '/welcome' />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Welcome
					    </a>
	
						<a href="<@spring.url  '/velocity' />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Velocity
					    </a>
					    
					    
						<a href="<@spring.url '/products/freemarker' /> " class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Freemarker Products
					    </a>
					    
					</p>    
				</div>
		</div>
	</section>
	
</body>
</html>
