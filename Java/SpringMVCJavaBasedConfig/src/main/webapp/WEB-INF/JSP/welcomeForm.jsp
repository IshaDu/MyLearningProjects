<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style>
.button{
	border:none;
	background:none;
	text-decoration: underline;
	cursor: pointer;
}
</style>
</head>
<body>
<h3>Welcome to the Beauty Treatments Salon</h3>
<form >
<table>
	<tr><td>1. </td><td><input type="submit" value="Beauty Treatements Available" formaction="viewAllBeautyTreatments" class="button" /></td></tr>
	<tr><td>2. </td><td><input type="submit" value="Book An Appointment" formaction="bookbeautyAppointmentPage" class="button"/></td></tr>
</table>
</form>
</body>
</html>