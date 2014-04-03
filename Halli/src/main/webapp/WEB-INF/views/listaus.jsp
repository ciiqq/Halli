<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Koulutusten listaus</title>
</head>
<body>

<c:forEach items="${koulutukset}" var="k">
	<c:out value="Aihe: ${k.aihe}"/><br/>
	<c:out value="Kuvaus: ${k.kuvaus}"/><br/>
	<c:out value="Klo: ${k.suomiKlo}"/><br/>
	<c:out value="Pvm: ${k.suomiPvm}"/><br/>
	<c:out value="Paikka: ${k.paikka}"/><br/>
	
	<c:out value="Kouluttajat: "/>
	<c:forEach items="${k.kouluttajat}" var="koul">
	<c:out value="${koul.etunimi} "/>
	<c:out value="${koul.sukunimi}"/><br/>
	</c:forEach>
	
	<c:out value="Avainsanat: "/>
	<c:forEach items="${k.avainsanat}" var="a">
	<c:out value="${a} "/>
	</c:forEach>	
</c:forEach>

</body>
</html>