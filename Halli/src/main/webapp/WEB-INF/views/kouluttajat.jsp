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
					<li class="active"><a href="<%=request.getContextPath()%>/opettaja/kouluttajat">Kouluttajat</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/aikataulut">Aikataulut</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat">Koulutukset</a></li>
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
						<h2 class="panel-title">Lista kouluttajista</h2>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<tr>
								<th>Opiskelijanumero</th>
								<th>Nimi</th>
								<th></th>
							</tr>
							<tr>
								<td>a1122334</td>
								<td>Testi testinen</td>
								<td><button type="button" class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>a1122334</td>
								<td>Testi testinen</td>
								<td><button type="button" class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>a1122334</td>
								<td>Testi testinen</td>
								<td><button type="button" class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>a1122334</td>
								<td>Testi testinen</td>
								<td><button type="button" class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>a1122334</td>
								<td>Testi testinen</td>
								<td><button type="button" class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>a1122334</td>
								<td>Testi testinen</td>
								<td><button type="button" class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#lisääexcel">Lisää kouluttajia Excelistä</button>
						<button class="btn btn-default" data-toggle="modal" data-target="#lisääkäsin">Lisää kouluttaja käsin</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="lisääexcel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Kouluttajien lisääminen excelist</h4>
      </div>
      <div class="modal-body">
        Laittakaa tähän tosi siisti käyttöliittymä
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Sulje ikkuna</button>
        <button type="button" class="btn btn-primary">Lisää kouluttajat</button>
      </div>
    </div>
  </div>
</div>

	<div class="modal fade" id="lisääkäsin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Kouluttajien lisääminen käsin</h4>
      </div>
      <div class="modal-body">
        Laittakaa tähän tosi siisti käyttöliittymä
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Sulje ikkuna</button>
        <button type="button" class="btn btn-primary">Lisää kouluttajat</button>
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