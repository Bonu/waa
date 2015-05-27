<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
	<meta charset=\"ISO-8859-1\">
	<title>Request Advice</title>
</head>
<body>
	<h2>Ask for advise about your favorite roast</h2>
	<form action="../action/advice" method="get">
		<select name="roast">
			<option value="-">--Choose Roast--</option>
			<option value="dark">Dark</option>
			<option value="medium">Medium</option>
			<option value="light">Light</option>
		</select><br/><br/>
		<input type="submit" value="Submit"/><br/><br/>
	</form>
</body>
</html>