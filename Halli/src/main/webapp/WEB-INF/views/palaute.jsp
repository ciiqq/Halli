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
<style>
	.error {
    	color:red;
	}
	.valid {
    	color:green;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
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
	
<!-- 	Vanha ilmoitus -->
<!-- 	<div class="alert alert-succes alert-dismissable"> -->
<!-- 		<button type="button" class="close" data-dismiss="alert"> -->
<!-- 		&times; -->
<!-- 		</button> -->
<!-- 		Palaute lähetetty. -->
<!-- 	</div> -->

<c:if test="${onnistunutviesti != null}">
	<div class="alert alert-success"><c:out value="${onnistunutviesti}"></c:out></div>
</c:if>

<c:if test="${virheviesti != null}">
	<div class="alert alert-danger"><c:out value="${virheviesti}"></c:out></div>
</c:if>
	
	
	<div class="container">
		<a class="btn btn-primary" href="testaus/uusi">Testaa</a>
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
							<form:select path="arvosana" class="form-control">
								<option value=""disabled selected>Valitse arvosana</option>
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
							<form:input path="opiskelijanumero" placeholder="1234567" maxlength="7" class="form-control" />
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
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#palauteForm").validate({
			    
		        // Specify the validation rules
		        rules: {
		            palauteteksti: {
		                required: true,
		                minlength: 5,
		                maxlength: 400
		            },
		            opiskelijanumero: {
		                required: true,
		                minlength: 7,
		                maxlength: 7,
		                number: true
		            },
		            arvosana: {
		            	required: true
		            }
		        },
		        
		        // Specify the validation error messages
		        messages: {
		        	palauteteksti: "Kirjoita palautteesi",
		            opiskelijanumero: "Kirjoita opiskelijanumerosi",
		            arvosana: "Valitse haluamasi numero arvosanaksi",
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
</body>
</html>