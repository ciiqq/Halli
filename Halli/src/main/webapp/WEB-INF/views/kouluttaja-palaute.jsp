<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Aikataulut</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
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
					<li><a href="<%=request.getContextPath()%>/kouluttaja/koulutus">Koulutus</a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/kouluttaja/palaute">Palaute</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout">Kirjaudu ulos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title">Koulutuksen palautteet</h2>
					</div>
					<div class="panel-body">
						<div class="well">
						<table class="palaute">
						  <tr>
						    <td class="otsikko">Arvosana</td>
						    <td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
						  </tr>
						  <tr>
						    <td class="otsikko">Palauteteksti</td>
						    <td>irure velit voluptate WinhaWille anim occaecat framework liveCD labore cupidatat nulla excepteur ad MyNet enim adipisicing id do aute magna adipisicing ut fugiat DAO määrityskuvasto nostrud pariatur occaecat proto officia olio laborum nulla incididunt laborum SQL Server tietohallinto rajapinta MariaDB officia proident product owner sunt käyttäjätarina dolore adipisicing mollit ex ad ut Visio culpa laborum tietohallinto irure definition of done user story reprehenderit occaecat est incididunt WinhaWille est innodb kohdeluokka cillum eclipse ut uimarata proident backlog item consectetur laboris ut SQL Server aute in commodo product owner aliqua dolore labore MariaDB </td>
						  </tr>
						</table>
						</div>
						<div class="well">
						<table class="palaute">
						  <tr>
						    <td class="otsikko">Arvosana</td>
						    <td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
						  </tr>
						  <tr>
						    <td class="otsikko">Palauteteksti</td>
						    <td>irure velit voluptate WinhaWille anim occaecat framework liveCD labore cupidatat nulla excepteur ad MyNet enim adipisicing id do aute magna adipisicing ut fugiat DAO määrityskuvasto nostrud pariatur occaecat proto officia olio laborum nulla incididunt laborum SQL Server tietohallinto rajapinta MariaDB officia proident product owner sunt käyttäjätarina dolore adipisicing mollit ex ad ut Visio culpa laborum tietohallinto irure definition of done user story reprehenderit occaecat est incididunt WinhaWille est innodb kohdeluokka cillum eclipse ut uimarata proident backlog item consectetur laboris ut SQL Server aute in commodo product owner aliqua dolore labore MariaDB </td>
						  </tr>
						</table>
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