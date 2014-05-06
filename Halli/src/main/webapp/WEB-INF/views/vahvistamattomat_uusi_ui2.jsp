<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<title>Koulutuksien vahvistus</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/colorbox.css">
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
					<li class="active"><a href="#">Koulutukset</a></li>
					<li><a href="#">Kouluttajat</a></li>
					<li><a href="#">Palautteet</a></li>
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
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Koulutuslistaus</div>
					<div class="panel-body">
						<p>Koulutukset</p>
					</div>

					<!-- Table -->
					<table class="table">
						<tr>
							<th>Aika</th>
							<th>Aihe</th>
							<th></th>

						</tr>

						<c:forEach var="k" items="${koulutukset}">

							<tr>
								<td>
									<p><c:out value="${k.suomiPvm}" />klo.<c:out value="${k.suomiKloAlku}" />-<c:out value="${k.suomiKloLoppu}" /></p>
								</td>

								<td><c:out value="${k.aihe}" /></td>

							</tr>

						</c:forEach>

					</table>
				</div>
				<div class="bottom-bar">
					<button type="submit" name="vahvista" href="#"
						class="btn btn-primary koulutuksienVahvistus" disabled>Vahvista
						ja julkaise valitut koulutukset</button>
					<button type="submit" name="vahvistaKaikki"
						href="VahvistaKaikkiKoulutukset"
						class="btn btn-primary kaikkienKoulutuksienVahvistus">Vahvista
						ja julkaise kaikki koulutukset</button>
				</div>

				Mitähän vittua?
				<div class="alert alert-danger">Ilmoitus!</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.colorbox.js"></script>
	<script type="application/javascript"
		src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>
</html>