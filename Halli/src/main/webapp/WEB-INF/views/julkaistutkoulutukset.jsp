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
					<li class="active"><a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat">Koulutukset</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/palautteet">Palautteet</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout">Kirjaudu ulos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat">Julkaisemattomat koulutukset</a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaistut">Julkaistut koulutukset</a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<table style="" class="table table-striped">
							<tr>
								<th>Aika</th>
								<th>Aihe</th>
								<th></th>
							</tr>
							<tr>
								<td>1.1.2012&nbsp;12:32</td>
								<td class="pitka">Access uimarata adipisicing ut tietokanta ut tempor</td>
								<td><button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#koulutuksentiedot">Koulutuksen tiedot</button></td>
							</tr>
							<tr>
								<td>1.1.2012&nbsp;12:32</td>
								<td class="pitka">SQL Server dolore anim WinhaWille adipisicing aliqua officia Spring</td>
								<td><button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#koulutuksentiedot">Koulutuksen tiedot</button></td>
							</tr>
							<tr>
								<td>1.1.2012&nbsp;12:32</td>
								<td class="pitka">WinhaWille MariaDB velit consequat dolor elit SQL Server et pariatur do Visio fugiat magna sint qui ut fugiat eiusmod</td>
								<td><button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#koulutuksentiedot">Koulutuksen tiedot</button></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="koulutuksentiedot" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Koulutuksen tiedot</h4>
      </div>
      <div class="modal-body">
        Laittakaa tähän tosi siisti käyttöliittymä
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger">Peruuta koulutus</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Sulje ikkuna</button>
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