<!DOCTYPE html>
<html>
<head>
	<title>CalculateResult</title>
</head>
<body>
	
		<input type="text" size="2" name="add1" value=" +  add1 +" />+ <input
			type="text" size="2" name="add2" value=" +  add2 + " />= <input
			type="text" size="4" name="sum" value=" +  sum + " readonly />
		<br /> 
		<%
    out.println(request.getAttribute("sum"));
%>

<%
    out.println(request.getAttribute("product"));
%>
		<input type="text" size="2" name="mult1"
			value=" +  mult1 + " />* <input type="text" size="2"
			name="mult2" value=" +  mult2 + " />= <input type="text"
			size="4" name="product" value=" + product + " readonly /><br />
		<input type="submit" value="Submit" />
	
</body>
</html>
