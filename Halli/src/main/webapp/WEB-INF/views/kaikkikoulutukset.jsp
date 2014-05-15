
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="fi.softala.bean.Palaute"%>
<%@ page import="fi.softala.controller.PalauteController"%>
<%@ page import="fi.softala.dao.PalauteDAO"%>
<%@ page import="fi.softala.dao.PalauteDAOimpl"%>
<%@ page import="fi.softala.dao.PalauteRowMapper"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Palautteet</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Halli</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Koulutukset</a></li>
					<li><a href="#">Kouluttajat</a></li>
					<li class="active"><a href="#">Palautteet</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Kirjaudu ulos</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">Kaikki palautteet</a></li>
					<li class="active"><a href="#">Koulutuskohtaiset
							palautteet</a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table table-hover">
							<tr>
								<td>Aihe</td>
								<td>Kuvaus</td>
							</tr>
							<c:forEach items="${kaikkikoulutukset}" var="kaikkikoulutukset">
								<tr>
									<td><c:out value="${kaikkikoulutukset.aihe}" /></td>
									<td><c:out value="${kaikkikoulutukset.kuvaus}" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>





