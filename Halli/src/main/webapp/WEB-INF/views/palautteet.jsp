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
					<li><a href="<%=request.getContextPath()%>/opettaja/kouluttajat">Kouluttajat</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/aikataulut">Aikataulut</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat">Koulutukset</a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/opettaja/palautteet">Palautteet</a></li>
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
						<h2 class="panel-title">Lista koulutuksista, joille on annettu palautetta</h2>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<tr>
								<th>Päivämäärä</th>
								<th>Nimi</th>
								<th>Palautteita</th>
								<th>Keskiarvo</th>
								<th></th>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td class="pitka">WinhaWille MariaDB velit consequat dolor elit SQL Server et pariatur do Visio fugiat magna sint qui ut fugiat eiusmod</td>
								<td>20 kpl</td>
								<td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
								<td><a href="<%=request.getContextPath()%>/opettaja/palautteet/koulutus" class="btn btn-primary btn-xs" >Lue palautteita</a></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td class="pitka">WinhaWille MariaDB velit consequat dolor elit SQL Server et pariatur do Visio fugiat magna sint qui ut fugiat eiusmod</td>
								<td>20 kpl</td>
								<td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
								<td><a href="<%=request.getContextPath()%>/opettaja/palautteet/koulutus" class="btn btn-primary btn-xs" >Lue palautteita</a></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td class="pitka">WinhaWille MariaDB velit consequat dolor elit SQL Server et pariatur do Visio fugiat magna sint qui ut fugiat eiusmod</td>
								<td>20 kpl</td>
								<td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
								<td><a href="<%=request.getContextPath()%>/opettaja/palautteet/koulutus" class="btn btn-primary btn-xs" >Lue palautteita</a></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td class="pitka">WinhaWille MariaDB velit consequat dolor elit SQL Server et pariatur do Visio fugiat magna sint qui ut fugiat eiusmod</td>
								<td>20 kpl</td>
								<td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
								<td><a href="<%=request.getContextPath()%>/opettaja/palautteet/koulutus" class="btn btn-primary btn-xs" >Lue palautteita</a></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td class="pitka">WinhaWille MariaDB velit consequat dolor elit SQL Server et pariatur do Visio fugiat magna sint qui ut fugiat eiusmod</td>
								<td>20 kpl</td>
								<td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
								<td><a href="<%=request.getContextPath()%>/opettaja/palautteet/koulutus" class="btn btn-primary btn-xs" >Lue palautteita</a></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td class="pitka">WinhaWille MariaDB velit consequat dolor elit SQL Server et pariatur do Visio fugiat magna sint qui ut fugiat eiusmod</td>
								<td>20 kpl</td>
								<td><img alt="3 tähteä" src="<%=request.getContextPath()%>/resources/3tahtea.png"></td>
								<td><a href="<%=request.getContextPath()%>/opettaja/palautteet/koulutus" class="btn btn-primary btn-xs" >Lue palautteita</a></td>
							</tr>
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