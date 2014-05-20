<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aikatauluslottilista</title>
</head>
<body>


<table>
<caption>Aikatauluslotti</caption>
<thead>
	<tr>
		<td>id</td>
		<td>pvm</td>
		<td>alkamisaika</td>
		<td>loppumisaika</td>
		<td>kouluttajaid</td>
		<td>opettajaid</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${aikatauluslotit}" var="slotti">
	<tr>
		<td><input type="text" value="${slotti.id}" name="id" readonly/></td>
		<td><input type="text" value="${slotti.pvm}" name="pvm" readonly/></td>
		<td><input type="text" value="${slotti.alkukello}" name="alkukello" readonly/></td>
		<td><input type="text" value="${slotti.loppukello}" name="loppukello" readonly/></td>
		<td><input type="text" value="${slotti.koulutustila}" name="koulutustila" readonly/></td>
		<td><input type="text" value="${slotti.koulutus}" name="koulutusid" readonly/></td>
		
		<%-- <td><c:out value="${slotti.id}"/></td> --%>
		<%-- <td><c:out value="${slotti.pvm}"/></td> --%>
		<%-- <td><c:out value="${slotti.alkukello}"/></td> --%>
		<%-- <td><c:out value="${slotti.loppukello}"/></td> --%>
		<%-- <td><c:out value="${slotti.kouluttjaid}"/></td> --%>
		<%-- <td><c:out value="${slotti.opettajaid}"/></td> --%>
		
	</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>