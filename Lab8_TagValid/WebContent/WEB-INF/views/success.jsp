<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUCCESS</title>
</head>
<body>

   <h2>Student Save successfully</h2>

  <p>
       Student Id: ${studentForm.id}<br>
       Student FirstName: ${studentForm.firstName}<br>
       Student LastName: ${studentForm.lastName}<br>
       Student Email: ${studentForm.email}<br> 
       Student Phone: ${studentForm.phone.area}-${studentForm.phone.prefix}-${studentForm.phone.number}<br> 
       
       
  </p>
</body>
</html>