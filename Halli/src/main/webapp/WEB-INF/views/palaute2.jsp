<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="fi.softala.bean.Palaute" %>
<%@ page import="fi.softala.controller.PalauteController" %>
<%@ page import="fi.softala.dao.PalauteDAO" %>
<%@ page import="fi.softala.dao.PalauteDAOImpl" %>
<%@ page import="fi.softala.bean.Palaute" %>
<%@ page import="fi.softala.dao.PalauteRowMapper" %>

<!DOCTYPE html>
<html>
<head>
<title>Palautteet</title>
</head>
<body>
	<h1>Palautteet</h1>

	<table border="1">
		<c:forEach items="${palautteet}" var="palautteet">
			<tr>
			<td>Id</td>
			<td>Arvosana</td>
			<td>Palaute</td>
			</tr>
			<tr>
			<!-- <td>ilmoittautuminen.koulutus_id</td> -->
				<td><c:out value="${palautteet.palaute_id}" /></td>
				<td><c:out value="${palautteet.arvosana}" /></td>
				<td><c:out value="${palautteet.palauteteksti}" /></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>