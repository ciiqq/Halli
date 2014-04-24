<%@page contentType="text/html;charset=UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="fi.softala.bean.Palaute" %>
<%@ page import="fi.softala.controller.PalauteController" %>
<%@ page import="fi.softala.dao.PalauteDAO" %>
<%@ page import="fi.softala.dao.PalauteDAOimpl" %>
<%@ page import="fi.softala.dao.PalauteRowMapper" %>

<!DOCTYPE html>
<html>
<head>
<title>Palautteet</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">

</head>
<body>
	<div class="container">
	<h1>Palautteet</h1>
	</div>

	<div class="container">
<tbody>
	<table class="table table-hover">
	<tr class="active"> 
			<td>Opiskelijanumero</td>
			<td>Arvosana</td> 
			<td>Palaute</td> 
			</tr>
		<c:forEach items="${opiskelijanpalautteet}" var="opiskelijanpalautteet">
		
			<tr>
				<td><c:out value="${opiskelijanpalautteet.opiskelijanro}" /></td>
				<td><c:out value="${opiskelijanpalautteet.arvosana}" /></td>
				<td><c:out value="${opiskelijanpalautteet.palauteteksti}" /></td>
			</tr>
		</c:forEach>
	</table> 
</tbody>
</div>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>