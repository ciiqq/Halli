<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kouludukset</title>
</head>
<body>



<table>
	<c:forEach var="apumuuttuja" items="${koulutukset}">
		<tr>
			<td>
				${apumuuttuja.pvm}
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="koulutukseen" name="${jokuvalue}">
			</td>
		</tr>
			
	</c:forEach>
	
</table>



</body>
</html>