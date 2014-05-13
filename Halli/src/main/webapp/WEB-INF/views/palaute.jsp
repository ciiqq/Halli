<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">

<title>Halli</title>
<meta name="description"
	content="Halli: Koulutusten hallinta- ja ilmoittautumisjärjestelmä">
<meta name="author" content="Haaga-Helia">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/colorbox.css">


<!--[if lt IE 9]>
            <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->
<style>
.error {
	color: red;
}

.valid {
	color: green;
}
</style>
</head>
<body>
	<c:if test="${onnistunutviesti != null}">
		<div class="alert alert-success">
			<c:out value="${onnistunutviesti}"></c:out>
		</div>
	</c:if>
	<c:if test="${virheviesti != null}">
		<div class="alert alert-danger">
			<c:out value="${virheviesti}"></c:out>
		</div>
	</c:if>

	<div class="container">
		<div class="sivumenu">
			<a href="./">
				<div class="nav-item">
					<div class="nav-icon tulevat"></div>
					<div class="nav-text">Tulevat luennot</div>
				</div>
			</a> <a href="./menneet">
				<div class="nav-item">
					<div class="nav-icon menneet"></div>
					<div class="nav-text">Menneet luennot</div>
				</div>
			</a> <a href="#" data-toggle="modal" data-target="#opiskelijanumeroModal"><div
					class="nav-item">
					<div class="nav-icon palaute"></div>
					<div class="nav-text">Anna palautetta</div>
				</div></a>

			<!-- Palauteikkuna Modal. Kysytään opiskelijanumero-->

			<div class="modal fade bs-example-modal-sm" tabindex="-1"
				role="dialog" aria-labelledby="opiskelijanumeroModal"
				aria-hidden="true" id="opiskelijanumeroModal">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<form action="anna_palautetta" id="opiskelijanumeroForm"
							method="post">
							<br> <label for="opiskelijanumero" style="color: grey;">Anna
								opiskelijanumero</label> <br> <input type="text"
								id="opiskelijanumero" name="opiskelijanumero"
								placeholder="a1234567" class="form-control" maxlength="8" /> <br>
							<input type="submit" value="Jatka" class="form-control"></input>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="main clearfix">
			<div class="ylapalkit">
				<div class="yla1">Halli: Koulutusten hallinta- ja
					ilmoittautumisjärjestelmä</div>
				<div class="yla2">
					<div class="yla2-icon admin"></div>
					<a href="./admin">Kirjaudu sisään järjestelmänvalvojana</a>
				</div>
			</div>
			<div class="fifty lista">
				<ul>
					<c:if test="${empty koulutukset}">
						<c:out value="Koulutuksia ei löytynyt" />
					</c:if>
					<c:forEach items="${koulutukset}" var="k">
						<li divid="<c:out value="${k.id}"/>" class="aihe"><c:out
								value="${k.aihe}" /> <span class="pvm"><c:out
									value="${k.suomiPvm}" /></span>
							</li>
						<li><button class="btn btn-primary" data-toggle="modal"
								data-target="#palauteModal">Anna palautetta</button></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<!-- Palauteikkuna Modal -->
	<div class="modal fade" id="palauteModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="palauteModal">Anna palautetta</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="palaute" id="palauteForm" method="post">
						<form:label path="arvosana">Arvosana</form:label>
						<br>
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
						<form:label path="opiskelijanumero">Opiskelijanumero (ainoastaan numero ilman a alkua)</form:label>
						<br>
						<form:input path="opiskelijanumero" placeholder="1234567"
							maxlength="7" class="form-control" />
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
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#palauteForm").validate({
				// Specify the validation rules
				rules : {
					palauteteksti : {
						required : true,
						minlength : 5,
						maxlength : 400
					},
					opiskelijanumero : {
						required : true,
						minlength : 7,
						maxlength : 7
					},
					arvosana : {
						required : true
					}
				},
				// Specify the validation error messages
				messages : {
					palauteteksti : "Kirjoita palautteesi",
					opiskelijanumero : "Kirjoita opiskelijanumerosi",
					arvosana : "Valitse haluamasi numero arvosanaksi",
				}
			});
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
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.colorbox.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/additional-methods.js"></script>
	<script type="application/javascript"
		src="<%=request.getContextPath()%>/resources/js/script.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>