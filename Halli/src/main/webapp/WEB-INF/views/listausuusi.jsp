<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!doctype html>

<html lang="en">
<head>
	<meta charset="utf-8">

	<title>Halli</title>
	<meta name="description" content="Halli: Koulutusten hallinta- ja ilmoittautumisjärjestelmä">
	<meta name="author" content="Haaga-Helia">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">

	<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>

<body>
	<div class="container">
		<div class="side-menu">
		<div class="nav-item">
			<div class="nav-icon"></div>
			<div class="nav-text">Tulevat luennot</div>
		</div>
		<div class="nav-item">
			<div class="nav-icon"></div>
			<div class="nav-text">Menneet luennot</div>
		</div>
		<div class="nav-item">
			<div class="nav-icon"></div>
			<div class="nav-text">Anna palautetta</div>
		</div>
		</div>
		<div class="main clearfix">
		<div class="fifty list">
		<ul>
		<c:forEach items="${koulutukset}" var="k">
		<div divid="<c:out value="${k.aihe}"/>" class="aihe"><li><c:out value="${k.aihe}"/></li></div>
		</c:forEach>
		</ul>
		</div>
		<div class="fifty details">
		<c:forEach items="${koulutukset}" var="k">
		<table id="<c:out value="${k.aihe}"/>" style="display:none">
			<tr>
				<td class="bold">Nimi</td>
				<td><c:out value="${k.aihe}"/></td>
			</tr>
			<tr>
				<td class="bold">Kouluttajat</td>
				<td><c:forEach items="${k.kouluttajat}" var="koul"><c:out value="${koul.etunimi} "/><c:out value="${koul.sukunimi} "/></c:forEach></td>
			</tr>
			<tr>
				<td class="bold">Aika</td>
				<td><c:out value="${k.suomiKlo}"/></td>
			</tr>
			<tr>
				<td class="bold">Avainsanat</td>
				<td><c:forEach items="${k.avainsanat}" var="a"><span class="label label-primary"><c:out value="${a}"/></span> </c:forEach></td>
			</tr>
			<tr>
				<td class="bold">Taso</td>
				<td><c:out value="${k.lahtotaso}"/></td>
			</tr>
			<tr>
				<td class="bold">Tila</td>
				<td><c:out value="${k.paikka}"/></td>
			</tr>
			<tr>
				<td class="bold">Kuvaus</td>
				<td><c:out value="${k.kuvaus}"/></td>
			</tr>
			</table>
		</c:forEach>
		</div>
		</div>
		<div class="bottom-bar">
			moi oon bottom bar
		</div>
		
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>

	<script>
     $(document).ready(function() {
    	 $(".aihe").click(function(){
    		var divId = $(this).attr("divId");
      		$("#"+divId).toggle();
      		$("#"+divId).siblings().hide();
    	 });
     });
    </script>
</body>
</html>
