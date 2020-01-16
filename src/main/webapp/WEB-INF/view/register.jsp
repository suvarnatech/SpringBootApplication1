<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration Page</h1>
	<form action="/save" method="post">
		<table>
			<tr>
				<td>Enter ID</td>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="empName" required="required"></td>
			</tr>

			<tr>
				<td>Enter Phone Number</td>
				<td><input type="text" name="phoneNumber" required="required"></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>