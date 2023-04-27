<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book an Appointment</title>
</head>
<body>
<h2>BOOK AN APPOINTMENT</h2>
<form action="bookAppointment">
	<table border="1">
		<tr>
			<td><label id="customerFirstNameLabel" >First Name </label><td>
			<td><input type="text" name="customerFirstNameInputBox"/></td>
		</tr>
		<tr>
			<td><label id="customerLastNameLabel" >Last Name </label><td>
			<td><input type="text" name="customerLastNameInputBox"/></td>
		</tr>
		<tr>
			<td><label id="apptDateLabel" >Date: </label><td>
			<td><input type="date" name="apptDateInputBox"/></td>
		</tr>
		<tr>
			<td><label id="apptTimeLabel" >Time: </label><td>
			<td><input type="time" name="apptTimeInputBox"/></td>
		</tr>
		<tr>
			<td><label id="beautyTreatmentNameLabel" >Beauty Treatment: </label><td>
			<td>
				<select  name="beautyTreatmentNameSelectionBox" >
					<c:forEach var="beautyTreatment"  items="${listBeautyTreatments}">
						<option >${beautyTreatment.beautyTreatmentName} </option>
					</c:forEach>
				</select></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Book Appointment"/>
			 	<input type="reset" value="Clear"/>
			 	<input type="submit" value="Back" formaction="backToWelcomeForm"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>