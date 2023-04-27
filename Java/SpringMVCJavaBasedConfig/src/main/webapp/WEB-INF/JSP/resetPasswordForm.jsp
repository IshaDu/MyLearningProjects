<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password Form</title>
</head>
<body>
<form>
<h2>Reset Password </h2>
<table>
	<tr>
		<td><label id="userNameResetFormLabel">Enter Username: </label></td>
		<td><input type="text" name="userNameResetFromTextBox" /></td>
	</tr>
	<tr>
		<td><label id="newPasswordResetFormLabel">Enter New Password: </label></td>
		<td><input type="text" name="newPasswordResetFromTextBox" /></td>
	</tr>
	<tr>
		<td><input type="submit" name="resetPasswordResetFromBtn" value="Reset Password"/></td>
	</tr>
</table>

</form>
</body>
</html>