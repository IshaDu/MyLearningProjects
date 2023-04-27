<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Beauty Treatments</title>
</head>
<body>
	<h3>ADD BEAUTY TREATMENTS FORM</h3>
	<form action="addBeautyTreatment">
		<table>
			<tr>
				<td><label id="treatmentNameLabel">Enter Treatment Name: </label></td>
				<td><input type="text" name="treatmentNameInputBox" /></td>
			</tr>
			<tr>
				<td><label id="treatmentPriceLabel">Enter Price of Treatment: </label></td>
				<td><input type="text" name="treatmentPriceInputBox" /></td>
			</tr>
			<tr >
				<td colspan="2"><input type="submit" name="addBeautyTreatmentBtn" value="ADD" />
				<input type="reset" name="resetBeautyTreatmentBtn" value="CLEAR" /></td>
			</tr>
		</table>
	</form>
</body>
</html>