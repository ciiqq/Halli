<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Aikataulut</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/admintyylit.css">
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="navbar-brand">Halli</div>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=request.getContextPath()%>/opettaja/kouluttajat">Kouluttajat</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/aikataulut">Aikataulut</a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat/">Koulutukset</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/palautteet">Palautteet</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<%=request.getContextPath()%>">Kirjaudu ulos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title">Muokkaa koulutusta</h2>
					</div>
					<div class="panel-body">
					<p>Koulutuksen muokkausformi</p>
					<p>//TODO: erottele muokkausnäkymä ja vahvistusnäkymä koska loogisuus</p>
					<div class="pull-right">
						<a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat/" class="btn btn-default">Peruuta</a>
						<a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat/" class="btn btn-primary">Tallenna muutokset</a>
					
					</div>
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