<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<title>Palaute</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
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
					<li class="active"><a href="#">Ensimmäinen</a></li>
					<li><a href="#">Toinen</a></li>
					<li><a href="#">Kolmas</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<a class="btn btn-primary" href="testaus/uusi">Testaa</a>
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#palauteModal">Anna palautetta</button>

		<!-- Palauteikkuna Modal -->
		<div class="modal fade" id="palauteModal" tabindex="-1" role="dialog"
			aria-labelledby="AnnaPalautetta" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="palauteModal">Anna palautetta</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="palaute" id="palauteForm" method="post">
								<form:label path="arvosana">Arvosana</form:label><br>
								<form:select path="arvosana" class="form-control">
								<option value="" disabled selected>Valitse arvosana</option>
								<form:option value="1">1 - Heikko</form:option>
								<form:option value="2">2 - Kohtalainen</form:option>
								<form:option value="3">3 - Hyvä</form:option>
								<form:option value="4">4 - Erinomainen</form:option>
								<form:option value="5">5 - Täydellinen</form:option>
							</form:select>
							<br>
							<form:label path="palauteteksti">Sanallinen arvio</form:label>
							<br>
							<form:textarea path="palauteteksti" rows="8" cols="50"
								maxlength="400" class="form-control"></form:textarea>
							<br>
							<form:label path="opiskelijanumero">Opiskelijanumero</form:label><br>
							<form:input path="opiskelijanumero" />
						</form:form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="peruutaButton">Peruuta</button>
						<button type="button" class="btn btn-primary" id="lahetaButton">Lähetä</button>

					</div>
				</div>
			</div>
		</div>
		<!-- /Palauteikkuna Modal -->
	</div>
	<!-- /container -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#lahetaButton').click(function() {
				$('#palauteForm').submit();
			});
			$('#peruutaButton').click(function() {
				$('#palauteForm').each(function() {
					this.reset();
				});
			});
		});
	</script>
</body>
</html>