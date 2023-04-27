<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beauty Treatment Registration Form</title>
</head>
<body>
<form:form method="post" modelAttribute="userDetails">
		<h3>Beauty Treatment Registration Form</h3>
	<table >
		<tr>
			<td><form:label path="userName" id="userNameLabel">User Name : </form:label></td>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td><form:label path="password" id="firstNameLabel">Password : </form:label></td>
			<td><form:input path="password" /></td>
		</tr>
		<tr>
			<td><form:label path="firstName" id="firstNameLabel">First Name : </form:label></td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td><form:label path="lastName" id="lastNameLabel">Last Name : </form:label></td>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td><form:label path="age" id="ageLabel">Age : </form:label></td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td><form:label path="gender" id="genderLabel">Gender : </form:label></td>
			<td><form:input path="gender" /></td>
		</tr>
		<tr>
			<td><form:label path="address" id="addressLabel">Address : </form:label></td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td><form:label path="phone" id="phoneLabel">Phone : </form:label></td>
			<td><form:input path="phone" /></td>
		</tr>
		<tr>
			<td><input name="registerButton" type="submit" value="Register" formaction="saveUserDetails"/></td>
			<td><input name="clearButton" type="reset" value="Clear"/></td>
		</tr>
	</table>

</form:form>
</body>
</html>