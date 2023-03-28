<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Trip Details To Calculate Trip Cost</title>
</head>
<body>
<h2>FUEL COST CALCULATOR FOR YOUR TRAVEL</h2>
<form action="calculateTripCost">
<table>
	<tr>
		<td><label id="carMileageLabel">Car Mileage: </label></td>
		<td><input name="carMileageInputBox" type="text" min="1"/></td>
	</tr>
	<tr>
		<td><label id="gasPriceLabel">Gas Price: </label></td>
		<td><input name="gasPriceInputBox" type="text" min="1"/></td>
	</tr>
	<tr>
		<td><label id="distanceTravelledLabel">Distance Traveled : </label></td>
		<td><input name="distanceTraveledInputBox" type="text" min="1" /></td>
	</tr>
	<tr>
    	<td><input id="calculateTripCostBtn" value="CALCULATE" type="submit"/></td>
    	<td><input id="resetBtn" value="RESET" type="reset"/></td>
    </tr>
	<tr>
		<td><label id="costOfTripLabel">Cost of Travel is : </label></td>
		<td>${cost}</td>
	</tr>
	 <tr>
		<td>${error}</td>
	</tr>
</table>
</form>  
</body>
</html>