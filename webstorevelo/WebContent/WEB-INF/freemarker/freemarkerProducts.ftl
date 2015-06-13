<#import "/spring.ftl" as spring />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
			</div>
		</div>
	</section>





	<section class="container">
		<div class="row">
 				<#list  products  as product> 
				  <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
				 
					<img src="<@spring.url "/resource/images/${product.productId}.png"/>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>${product.unitPrice} USD</p>
							<p>Available ${product.unitsInStock} units in stock</p>
							<p>
								<a
									href="<@spring.url "/products/product?id=${product.productId}" />"
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>

						</div>
					</div>
				</div>
			   </#list>
		</div>
	</section>
</body>
</html>
