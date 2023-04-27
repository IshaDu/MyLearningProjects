<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Beauty Items</title>
</head>
<body>
<form>
  <h2>BEAUTY TREATMENTS AVAILABLE</h2>	
  <table border="1">
  	<thead>
  		<tr>
  			<td>Beauty Treatment Name</td>
  			<td>Beauty Treatment Price</td>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach var="beautyTreatment"  items="${listBeautyTreatments}">
  		<tr>
  			<td>${beautyTreatment.beautyTreatmentName}</td>
  			<td>${beautyTreatment.beautyTreatmentPrice}</td>
  		</tr>
  		</c:forEach>
  	</tbody>
  </table>
  <input type="submit" value="Back" formaction="backToWelcomeForm"/>
  </form>
</body>
</html>