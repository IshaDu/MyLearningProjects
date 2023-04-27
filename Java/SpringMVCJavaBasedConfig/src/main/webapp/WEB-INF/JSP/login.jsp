<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beauty Treatments Login Form</title>
<style>
	.table {
		align:'center';
	}
	.center {
  		margin-left: auto;
  		margin-right: auto;
	}
</style>
</head>
<body >
<form >
<div >
<h2 align='center'> BEAUTY TREATMENT SALON</h2>
<table border="1" class="center">
<tr>
	<td><label id="newUserRegistrationLabel">New User ?</label>
	<input type="submit" name="newUserRegistrationBtn" value="Register" formaction="register"/></td>
</tr>
<tr>
	<td colspan="2">Enter Login Details :</td>
</tr>
<tr>
	<td><label id="userNameLabel">Username: </label></td>
	<td><input type="text" name="userNameTextBox"/></td>
</tr>
<tr>
	<td><label id="passwordLabel">Password: </label></td>
	<td><input type="text" name="PasswordTextBox"/></td>
</tr>
<tr>
	<td><input type="submit" name="loginBtn" value="Login" formaction="welcomePage"/></td>
	<td><input type="submit" name="forgotPasswordBtn" value="Forgot Password ?" formaction="resetPasswordPage"/></td>
</tr>

</table>
<label>${validUserMessage}</label>
</div>
</form>

</body>
</html>