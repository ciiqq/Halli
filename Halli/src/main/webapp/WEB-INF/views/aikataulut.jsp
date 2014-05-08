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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-datetimepicker.min.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>


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
					<li><a
						href="<%=request.getContextPath()%>/opettaja/kouluttajat">Kouluttajat</a></li>
					<li class="active"><a
						href="<%=request.getContextPath()%>/opettaja/aikataulut">Aikataulut</a></li>
					<li><a
						href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat">Koulutukset</a></li>
					<li><a
						href="<%=request.getContextPath()%>/opettaja/palautteet">Palautteet</a></li>
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
						<h2 class="panel-title">Lista aikataulusloteista</h2>
					</div>

					<div class="panel-body">
						<table class="table table-striped">
							<tr>
								<th>Päivämäärä</th>
								<th>Kellonaika</th>
								<th>Tila</th>
								<th>Status</th>
								<th></th>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td>11:00-11:00</td>
								<td>7005</td>
								<td>Varattu</td>
								<td><button type="button"
										class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td>11:00-11:00</td>
								<td>7005</td>
								<td>Varattu</td>
								<td><button type="button"
										class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td>11:00-11:00</td>
								<td>7005</td>
								<td>Varattu</td>
								<td><button type="button"
										class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td>11:00-11:00</td>
								<td>7005</td>
								<td>Varattu</td>
								<td><button type="button"
										class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td>11:00-11:00</td>
								<td>7005</td>
								<td>Varattu</td>
								<td><button type="button"
										class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
							<tr>
								<td>12.12.2013</td>
								<td>11:00-11:00</td>
								<td>7005</td>
								<td>Varattu</td>
								<td><button type="button"
										class="pull-right btn btn-danger btn-xs">Poista</button></td>
							</tr>
						</table>
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#lisääslotti">Lisää aikatauluslotti</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<form action="/koulutusjarjestelma/opettaja/aikataulut/lisaa" modelAttribute="aikaslotti"
		method="post">
		<div class="modal fade" id="lisääslotti" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Aikatauluslotin
							lisääminen</h4>
					</div>

					<div class="modal-body">

						<div class="container">
							<p>Valitse päivämäärä:</p>
							<div class="row">
								<div class='col-sm-6'>
									<div class="form-group">
										<div class='input-group date' id='paivamaara'
											data-date-format="DD.MM.YYYY">
											<input type='text' class="form-control" /> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span> </span>
										</div>
									</div>
								</div>
								<script type="text/javascript">
									$(function() {
										$('#paivamaara').datetimepicker({
											language : 'fi',
											pickTime : false
										});
									});
								</script>
							</div>
							<p>Valitse alkamisaika:</p>
							<div class="row">
								<div class='col-sm-6'>
									<div class="form-group">
										<div class='input-group date' id='alkuaika'>
											<input type='text' class="form-control" /> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-time"></span> </span>
										</div>
									</div>
								</div>
								<script type="text/javascript">
									$(function() {
										$('#alkuaika').datetimepicker({
											language : 'fi',
											pickDate : false
										});
									});
								</script>
							</div>
							<p>Valitse päättymisaika:</p>
							<div class="row">
								<div class='col-sm-6'>
									<div class="form-group">
										<div class='input-group date' id='loppuaika'>
											<input type='text' class="form-control" /> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-time"></span> </span>
										</div>
									</div>
								</div>
								<script type="text/javascript">
									$(function() {
										$('#loppuaika').datetimepicker({
											language : 'fi',
											pickDate : false
										});
									});
								</script>
							</div>
							<p>Syötä tila:</p>


							<div class='col-sm-6'>
								<div class="form-group">
									<div class='input-group text' id='tila'>
										<input type='text' class="form-control" /> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-pencil"></span> </span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Sulje
						ikkuna</button>
					<button type="submit" class="btn btn-primary">Lisää slotti</button>
				</div>


			</div>
		</div>
		</div>
	</form>

	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/moment.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap-datetimepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap-datetimepicker.fi.js"></script>




</body>
</html>