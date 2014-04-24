<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE>
<html>
<head>
	<title>Kouluttajien lisäys</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Halli</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Koulutukset</a></li>
					<li><a href="#">Kouluttajat</a></li>
					<li><a href="#">Palautteet</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Kirjaudu ulos</a></li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div>
							<form action="lisaaLista" method="post" enctype="multipart/form-data">
								
								<fieldset>		
									<legend>Kouluttajalistan lisäys</legend>
									<p>
										<input type="file" name="kouluttajaLista" />
									</p>
									<p>
										<input type="submit" value="Lisää"/>
									</p>
								</fieldset>
							</form>
						</div>
						
						<div>
							<form:form action="lisaaKouluttaja" modelAttribute="kouluttaja" method="post">
			  					<fieldset>		
									<legend>Kouluttajan tiedot</legend>
									<p>
										<form:label	path="etunimi">Etunimi</form:label><br/>
										<form:input path="etunimi"/><form:errors path="etunimi"/>
									</p>
									<p>	
										<form:label path="sukunimi">Sukunimi</form:label><br/>
										<form:input path="sukunimi"/><form:errors path="sukunimi"/>
									</p>
									<p>	
										<form:label path="opiskelijanro">Opiskelijanumero</form:label><br/>
										<form:input path="opiskelijanro"/><form:errors path="opiskelijanro"/>
									</p>
									<p>	
										<button type="submit">Lisää</button>
									</p>
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>