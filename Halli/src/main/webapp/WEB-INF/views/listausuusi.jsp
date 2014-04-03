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
		<li>Moi</li>
		<li>Moi</li>
		<li class="active">Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		<li>Moi</li>
		</ul>
		</div>
		<div class="fifty details">
		<table id="dynamic-details">
			<tr>
				<td class="bold">Nimi</td>
				<td>Nimi</td>
			</tr>
			<tr>
				<td class="bold">Pitäjä</td>
				<td>Pitäjä</td>
			</tr>
			<tr>
				<td class="bold">Aika</td>
				<td>Aika</td>
			</tr>
			<tr>
				<td class="bold">Avainsanat</td>
				<td>Avainsanat</td>
			</tr>
			<tr>
				<td class="bold">Taso</td>
				<td>Taso</td>
			</tr>
			<tr>
				<td class="bold">Tila</td>
				<td>Tila</td>
			</tr>
			<tr>
				<td class="bold">Kuvaus</td>
				<td>Kuvaus</td>
			</tr>
		</table>
		</div>
		</div>
		<div class="bottom-bar">
			moi oon bottom bar
		</div>
		
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
