<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Koulutusten listaus</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>


<table class="table table-bordered table-striped">
<c:forEach items="${koulutukset}" var="k">
	<th colspan="2"> </th>
	<tr><td>Aihe:</td><td><c:out value="${k.aihe}"/></td></tr>
	<tr><td>Kuvaus:</td><td><c:out value="${k.kuvaus}"/></td></tr>
	<tr><td>Lähtötaso:</td><td><c:out value="${k.lahtotaso}"/></td></tr>
	<tr><td>Kellonaika:</td><td><c:out value="${k.suomiKlo}"/></td></tr>
	<tr><td>Päivämäärä:</td><td><c:out value="${k.suomiPvm}"/></td></tr>
	<tr><td>Paikka:</td><td><c:out value="${k.paikka}"/></td></tr>
	<tr><td>Kouluttajat:</td><td><c:forEach items="${k.kouluttajat}" var="koul"><c:out value="${koul.etunimi} "/><c:out value="${koul.sukunimi} "/></c:forEach></td></tr>
	<tr><td>Avainsanat:</td><td><c:forEach items="${k.avainsanat}" var="a"><span class="label label-primary"><c:out value="${a}"/></span> </c:forEach></td></tr>
</c:forEach>
</table>

<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>