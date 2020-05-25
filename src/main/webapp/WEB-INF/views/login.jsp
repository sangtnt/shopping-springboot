<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="POST">
		<table>
			<tr>
				<td colspan="2" style="color:red">${message}</td>
			</tr>
			<tr>
				<td>Username: </td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Login</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>