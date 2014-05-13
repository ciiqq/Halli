<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE>
<html>
<head>
	<title>Kouluttajat</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
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
					<li><a href="#">Koulutukset</a></li>
					<li class="active"><a href="#">Kouluttajat</a></li>
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
					<div class="panel-heading">
                        <h2 class="panel-title">Lista kouluttajista</h2>
                    </div>
                    <div class="panel-body">
                    
                    
                    <c:if test="${not empty lisatyt}">
	                    <div class="alert alert-success">  
	  					<a class="close" data-dismiss="alert">×</a>  
	  					<strong>Lisätyt kouluttajat</strong>  
	  					<c:forEach items="${lisatyt}" var="k">
							<p><c:out value="${k.opiskelijanro}"/> <c:out value="${k.etunimi}" /> <c:out value="${k.sukunimi}" /></p>
						</c:forEach>
						</div>
					</c:if>
					
					<c:if test="${not empty eiLisatyt}">
						<div class="alert alert-warning">  
		  				<a class="close" data-dismiss="alert">×</a>  
		  				<strong>Seuraavat opiskelijanumerot löytyvät jo kannasta</strong>
		  				<c:forEach items="${eiLisatyt}" var="k">
							<p><c:out value="${k.opiskelijanro}"/> <c:out value="${k.etunimi}" /> <c:out value="${k.sukunimi}" /></p>
						</c:forEach>
						</div>
					</c:if>

                    
                   		 <c:choose>
							<c:when test="${not empty kouluttajat}">
								<table class="table table-striped">
		                            <tr>
		                                <th>Opiskelijanumero</th>
		                                <th>Nimi</th>
		                                <th></th>
		                            </tr>
		                            <c:forEach items="${kouluttajat}" var="k">
										<tr>
			                                <td><c:out value="${k.opiskelijanro}" /></td>
			                                <td><c:out value="${k.etunimi}" /> <c:out value="${k.sukunimi}" /></td>
			                                <td><button type="button" class="pull-right btn btn-danger btn-xs">Poista</button></td>
		                       		    </tr>
									</c:forEach>
		                            
	                     	  	</table>

							</c:when>
							
							<c:otherwise>
								<p><br>Järjestelmässä ei ole yhtään kouluttajaa</p>
							</c:otherwise>
						
						</c:choose>
                        
                        <button class="btn btn-primary" data-toggle="modal" data-target="#lisaaKouluttajalista">Lisää kouluttajia Excelistä</button>
                        <button class="btn btn-default" data-toggle="modal" data-target="#lisaaKouluttaja">Lisää yksittäinen kouluttaja</button>
                        
                    </div>
						<!-- Modal -->
						<div class="modal fade" id="lisaaKouluttaja" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						        <h4 class="modal-title" id="myModalLabel">Kouluttajan lisäys</h4>
						      </div>
						      
						      
						      <form:form action="/koulutusjarjestelma/opettaja/kouluttajat/lisaaKouluttaja" modelAttribute="kouluttaja" method="post">
						      <div class="modal-body">
															
										<p>
											<form:label	path="etunimi" required="">Etunimi</form:label><br/>
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

								
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Peruuta</button>
						        <button type="submit" class="btn btn-primary">Lisää</button>
						        
						      </div>
						      </form:form>
						    </div>
						  </div>
						</div>
						
						
						<div class="modal fade" id="lisaaKouluttajalista" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						        <h4 class="modal-title" id="myModalLabel">Kouluttajalistan lisäys</h4>
						      </div>
						      <form action="/koulutusjarjestelma/opettaja/kouluttajat/lisaaLista" method="post" enctype="multipart/form-data">
						      <div class="modal-body">

									<p>
										Anna excel lista</br>
										<input type="file" name="kouluttajaLista" />
									</p>

						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Peruuta</button>
						        <button type="submit" class="btn btn-primary">Lisää</button>
						        
						      </div>
						      </form>
						    </div>
						  </div>
						</div>
						
				</div>
			</div>
		</div>
	</div>
	
	
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>  
	<script src="twitter-bootstrap-v2/docs/assets/js/bootstrap-alert.js"></script>  

</body>
</html>