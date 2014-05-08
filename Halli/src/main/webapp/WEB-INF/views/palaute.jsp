<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<title>Palaute</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							$("#palauteForm").validate();
							$("#arvosana").rules("add", {
								required : true,
								messages : {
									required : "Valitse arvosana"
								}
							});
							$("#palauteteksti").rules("add", {
								required : true,
								minlength : 5,
								messages : {
									required : "Kirjoita palaute",
									minlength : "Anna kelvollinen palaute"
								}
							});
							$("#opiskelijanumero")
									.rules(
											"add",
											{
												required : true,
												minlength : 7,
												messages : {
													required : "Anna opiskelijanumero, a kirjaimella tai ilman",
													minlength : "Syötä vähintään 7 numeroa"
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
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#palauteModal">Anna palautetta</button>

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
							<form:select id="arvosana" path="arvosana" class="form-control">
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
							<form:textarea id="palauteteksti" path="palauteteksti" rows="8"
								cols="50" class="form-control" maxlength="400"></form:textarea>
							<br>
							<form:label path="opiskelijanumero">Opiskelijanumero</form:label>
							<br>
							<form:input id="opiskelijanumero" path="opiskelijanumero"
								placeholder="a1234567" class="form-control" maxlength="8" />
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
</body>
</html>