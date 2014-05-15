

<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>

<html lang="en">
<head>

<meta charset="utf-8">

<title>Halli</title>
<meta name="description"
	content="Halli: Koulutusten hallinta- ja ilmoittautumisjärjestelmä">
<meta name="author" content="Haaga-Helia">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/hallityylit.css">
<style>
.error {
	color: red;
}

.valid {
	color: green;
}
</style>

<!--[if lt IE 9]>
            <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->
</head>

<body>
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
			</a>
			<a href="" data-toggle="modal"
			data-target="#opiskelijanumeroModal"><div class="nav-item aktiivinen">
				<div class="nav-icon palaute"></div>
				<div class="nav-text">Anna palautetta</div>
			</div></a>
		</div>
		<div class="modal fade bs-example-modal-sm" tabindex="-1"
				role="dialog" aria-labelledby="opiskelijanumeroModal" aria-hidden="true" id="opiskelijanumeroModal">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<form action="anna_palautetta" id="opiskelijanumeroForm"
							method="post">
							<br>
							<label for="opiskelijanumero" style="color:grey;">Anna opiskelijanumerosi</label>
							<br>
							<input type="text" id="opiskelijanumero" name="opiskelijanumero"
								placeholder="a1234567" class="form-control" maxlength="8" />
							<br>
							<input type="submit" value="Jatka" class="form-control btn btn-primary"></input>
						</form>
					</div>
				</div>
		</div>
		<div class="main clearfix">
		<div class="ylapalkit">
			<div class="yla1">Halli: Koulutusten hallinta- ja
				ilmoittautumisjärjestelmä</div>
			<div class="yla2"><div class="yla2-icon admin"></div><a href="./admin">Kirjaudu sisään järjestelmänvalvojana</a></div>
		</div>
			<div class="fifty lista">
				
				<ul>
				 <c:if test="${virheviesti != null}">
							<div class="alert alert-danger">
								<c:out value="${virheviesti}"></c:out>
							</div>
						</c:if>
						<%--<c:if test="${onnistunutviesti != null}">
							<div class="alert alert-success">
								<c:out value="${onnistunutviesti}"></c:out>
							</div>
						</c:if> --%>
					<c:if test="${empty koulutukset}">
						<c:out value="Ei löytynyt koulutuksia, joille voisit antaa palautetta." />
					</c:if>
					<c:if test="${!empty koulutukset}">
					
					<p>Anna palautetta</p>
					<form:form modelAttribute="palaute" method="post" id="palauteForm">
						<label>Koulutus</label>
						<select class="form-control" name="koulutus_id">
							<option value="" disabled selected>Valitse koulutus</option>
							<c:forEach items="${koulutukset}" var="k">
								<option value="${k.id}"><c:out value="${k.aihe}"/></option>
							</c:forEach>
						</select>
						<br>
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
						<form:textarea path="palauteteksti" rows="4" cols="50"
							minlength="10" maxlength="400" class="form-control" placeholder="Kirjoita jokin palaute..." type="text"></form:textarea>
						<br>
						<form:input type="hidden" path="opiskelijanro"></form:input>
						<button type="reset" class="btn btn-default">Tyhjennä</button>
						<button type="submit" class="btn btn-primary">Lähetä palaute</button>
					</form:form>	
					</c:if>				
				</ul>
			</div>			
			<div class="fifty tiedot">
				<div class="table-container">
					<c:choose>
						<c:when test="${viesti==null}">
							<span
								style="display: block; text-align: center; margin-top: 96px; margin-bottom: 96px;">Valitse listasta koulutus, jolle haluat antaa palautetta.</span>
							<br />
						</c:when>

						<c:otherwise>
							<span
								style="display: block; text-align: center; margin-top: 96px; margin-bottom: 96px; color:green; font-size:30px;">
								Kiitos palautteesta!</span>
							<br />
						</c:otherwise>
					</c:choose>
				</div>
				
			</div>
			<div class="alapalkki">
			</div>
		</div>
	</div>

	<!-- lightboxin sisältö -->
	<!-- lightboxin sisältö päättyy -->
	
	<!-- Bootstrap Modal -->	
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
		
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/additional-methods.js"></script>
	<script type="application/javascript"
		src="<%=request.getContextPath()%>/resources/js/script.js"></script>
	
</body>
</html>
