<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
	<title>Insert title here</title>
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
		<div class="panel panel-default">
  <!-- Default panel contents -->
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
  
  <c:forEach var="kt" items="${koulutukset}">
  		
		<tr>
			<td>
				<p>${kt.aikaslotti.pvm} klo. ${kt.aikaslotti.alkukello} - ${kt.aikaslotti.loppukello}
			</td>
			
			<td>
				${kt.aihe}
			</td>
			
							
			
		
			<td>
				<a href="koulutuslistaus/${kt.id}"><input class="btn btn-primary" type="button" value="Koulutukseen" name="lista/${kt.id}"></a>
			</td>
			
		</tr>
			
	</c:forEach>
   
  </table>
</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>