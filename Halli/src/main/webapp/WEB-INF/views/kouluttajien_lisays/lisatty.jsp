<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

    
<!DOCTYPE>
<html>
<head>
<title>Kouluttajat lisättyd</title>
</head>
<body>

<h1>Lisäys suoritettu</h1>

<div>
<h2>Lisätyt kouluttajat</h2>

<c:forEach items="${lisatyt}" var="k">
<p><c:out value="${k.etunimi}" /> <c:out value="${k.sukunimi}" /></p>
</c:forEach>

</div>

<div>
<h2>Ei lisätyt kouluttajat</h2>

<c:forEach items="${eiLisatyt}" var="k">
<p><c:out value="${k.etunimi}" /> <c:out value="${k.sukunimi}" /></p>
</c:forEach>

</div>


</body>
</html>