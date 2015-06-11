<#import "/spring.ftl" as spring />
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Freemarker List</title>
</head>
<body bgcolor="#E6E6FA">
 
<UL style='list-style-type:none;' />

  	<section>
		<div class="jumbotron">
 
		<H1>Select Category</H1>

	 <p>
		 <h3>Spring Freemarker Select</h3>
			<form action="saveFreemarker" method="POST">
	            <@spring.bind "product" />
	  
	 			<@spring.formSingleSelect "product.category", categoryList, " " />
	  
	 	 <h3>Regular Freemarker Select</h3>
	 
             <select name="category">
    
               <#list  category as type >
                    <#if  product.category  ==  type >
                        <#assign  selected = "selected" >
                    <#else>
                        <#assign  selected = "" >
                    </#if>
                        <option  selected  value="${type}">${type}</option>
              </#list>                     

             </select>

 	</p>
 
 
		</form>
					<p>
						<a href="<@spring.url  '/welcome' />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Welcome
					    </a>
						<a href="<@spring.url  '/demo' />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Compare Select
					    </a>


   </div>
   </section>

</body>
</html>
