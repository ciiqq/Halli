<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-modal.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/koulutuslistaustyylit.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.4.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.timepicker.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">


<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.4.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.timepicker.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modal.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modalmanager.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jqBootstrapValidation.js"></script>


<script> 
 	$(document).ready(function() {
 		$( "#datepicker" ).datepicker({dateFormat: 'dd.mm.yy'});
 		$( ".timepicker" ).timepicker({ 'timeFormat': 'H:i', 
 			'minTime': '07:00',
 			'maxTime': '21:00'
 		});
 	});  

  
    function() {$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
     });

 
 	 </script>


<title>Aikataulut</title>

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
					<li><a href="<%=request.getContextPath()%>/opettaja/kouluttajat">Kouluttajat</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/aikataulut">Aikataulut</a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/opettaja/koulutukset/julkaisemattomat/">Koulutukset</a></li>
					<li><a href="<%=request.getContextPath()%>/opettaja/palautteet">Palautteet</a></li>
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
  <!-- Default panel contents -->
  
  <div class="panel-heading">${ks.aihe}</div>
  
  <div class="panel-body">    
    <p>${ks.kuvaus}</p>    
  </div>

  <!-- Table -->
  <table class="table">
  
  <tr>
  
    	<th>Kouluttajat</th>
    	<td>
    	<c:forEach var="kouluttaja" items="${ks.kouluttajat }">
    		<c:out value="${kouluttaja.etunimi}" /> <c:out value="${kouluttaja.sukunimi}" />
    	</c:forEach>
    	</td> 
    </tr>
    
    <tr>
    	<th>Arvioiva opettaja</th>
    	<td>
    	<c:forEach var="opettaja" items="${ks.opettajat }">
    		<c:out value="${opettaja.etunimi}" /> <c:out value="${opettaja.sukunimi}" />
    	</c:forEach>
    	</td> 
    </tr>
  
  <tr>
    	<th>Päivämäärä</th>
    	<td>${ks.aikaslotti.pvm}</td> 
    </tr>
  	
  	<tr> 
  		<th>Alkaa</th>
  		<td>${ks.aikaslotti.alkukello} </td>
  	</tr>
  	
  	<tr>  	
		<th>Loppuu</th>	  
	    <td>${ks.aikaslotti.loppukello}</td>    
    </tr>
    
    <tr>
    	<th>Koulutustila</th>
    	<td>${ks.aikaslotti.koulutustila}</td> 
    </tr>
    
    <tr>
    	<th>Lähtötaso</th>
    	<td>${ks.lahtotaso}</td> 
    </tr>
    
    <tr>
    	<th>Avainsanat</th>
    	<td>
    	<c:forEach var="a" items="${ks.avainsanat}">
    		<p><c:out value="${a.avainsana}" /></p>
    	</c:forEach>
    	</td> 
    </tr>
    
    <!--
    <tr>
    	<th>Näkyvyys</th>
    	<td>${ks.nakyvyys}</td> 
    </tr> -->
    
  </table>
</div>
</div>
</div>
<a id="muokkausPainike" type="button" class="btn btn-primary"  href="#test_modal" data-toggle="modal">Muokkaa</a>
<button class="btn btn-danger" data-toggle="modal" href="#peruutusModal">Peruuta Koulutus</button>
<button class="btn btn-success" data-toggle="modal" href="#julkaisuModal">Julkaise Koulutus</button>


<!-- Jos muokkaus onnistui, näytetään käyttäjälle teksti siitä -->
<c:if test="${muokkausOnnistui != null}">
	<p id="mop" class="text-success bg-success" style="padding: 30px; font-size: 2em;">
		<c:out value="${muokkausOnnistui}" />
	</p>
</c:if>

<!-- Modal-popup, jolla voidaan peruuttaa koulutus -->
<div id="peruutusModal" class="modal fade">
  <div class="modal-dialog modal-sm modal-varjo">
    <div class="modal-content">
    <div class="modal-header">
    	<h3><c:out value="${ks.aihe}" /></h3>
    </div>
    	<div class="modal-body">
      		Haluatko varmasti peruuttaa koulutuksen?
        </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
      <a href="peruutus/${ks.id}" class="btn btn-danger">Vahvista</a>
      </div>
    </div>
  </div>
</div>

<!-- Modal-popup, jolla voidaan julkaista koulutus -->
<div id="julkaisuModal" class="modal fade">
  <div class="modal-dialog modal-sm modal-varjo">
    <div class="modal-content">
    <div class="modal-header">
    	<h3><c:out value="${ks.aihe}" /></h3>
    </div>
    	<div class="modal-body">
      		Haluatko varmasti julkaista koulutuksen?
      		
      		<span style="color:red;">HUOM! Koulutusta ei voi tämän jälkeen muokata!</span>
        </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
      <a href="julkaisu/${ks.id}" class="btn btn-success">Julkaise koulutus</a>
      </div>
    </div>
  </div>
</div>


<!-- Modal-popup, jolla voidaan muokata tietoja -->
<div class="modal fade" id="test_modal">
  <div class="modal-dialog modal-varjo">
    <div class="modal-content">
      <div class="modal-header">
      <h3><c:out value="${ks.aihe}" /></h3>


        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"><c:out value="${ks.aikaslotti.pvm}" />, <c:out value="${ks.aikaslotti.alkukello}" />-<c:out value="${ks.aikaslotti.loppukello}" /></h4>
      </div>

       <form:form id="modal-form" method="POST" modelAttribute="muokattavaKoulutus" novalidate="novalidate">
      <div class="modal-body">



           <table class="table">
           
           
        
			  <tr>
			   
			  	<th><form:label path="aihe" name="aihe">Aihe</form:label></th>	 		  
			  	<td><form:input id="aihe" path="aihe" required="required" value="${ks.aihe}"/>  </td> 
			  	<td><form:errors path="aihe"></form:errors></td>
			  	
			  </tr>  
			  
			  <tr>
			  	<th><form:label path="kuvaus" name="kuvaus">Kuvaus</form:label></th>
			  	<td><form:textarea id="kuvaus" class="kuvaus" path="kuvaus" style="resize:none;" value="${ks.kuvaus}" cols="40" rows="5"/> </td>
			  	<td><form:errors id="kuvaus-error" path="kuvaus"></form:errors></td>
			  	
			  </tr>    
			  
			   <tr>
			    	<th><form:label path="lahtotaso">Lähtötaso</form:label></th>
			  	<td><form:input path="lahtotaso" value="${ks.lahtotaso}"/> </td>
			  	<td><form:errors path="lahtotaso"></form:errors></td>
			    </tr>
			  
			 <tr>
			    <th><form:label path="aikaslotti.pvm">Päivämäärä</form:label></th>
			  	<td><c:out value="${ks.aikaslotti.pvm}"/> </td>
			  </tr>
			  	
			  <tr> 
			  	<th><form:label path="aikaslotti.alkukello">Alkaa</form:label></th>
			  	<td><c:out value="${ks.aikaslotti.alkukello}"/></td>
			  </tr>
			  	
			  	<tr>  	
					<th><form:label path="aikaslotti.loppukello">Loppuu</form:label></th>
			  		<td><c:out value="${ks.aikaslotti.loppukello}"/> </td>    
			  </tr>
			    
			    <tr>
			    	<th><form:label path="aikaslotti.koulutustila">Koulutustila</form:label></th>
			  	<td><c:out value="${ks.aikaslotti.koulutustila}"/></td> 
			    </tr>
			    
			     <tr>
			    	<th><form:label path="aikaslotti.pvm">Siirrä koulutus</form:label></th>
			    	
			  	<td>
			  	<select name="siirto">
			  		<option value="0">Valitse aika</option>
				  	<c:forEach var="vp" items="${vapaat}">
				  		<option value="${vp.id}"><c:out value="${vp.pvm}"/>, <c:out value="${vp.alkukello}"/> - <c:out value="${vp.loppukello}"/>, luokka: <c:out value="${vp.koulutustila}"/></option>
				  	</c:forEach>
			  	</select>
			  	
			  	</td> 
			    </tr>
			    
			   
			    
			   <!--  <tr>
			    	<th><form:label path="nakyvyys">Näkyvyys</form:label></th>
			  		<td><form:input path="nakyvyys" value="${ks.nakyvyys}"/> </td> 
			  		<td><form:errors path="nakyvyys"></form:errors></td>
			    </tr> -->
			    
			    </table>
			    
		  
    
 
  
  			<div class="modal-footer">
			    <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
        	<button id="modal-form-submit2" type="submit" class="btn btn-primary">Tallenna muutokset</button>
        	 </div>
 	

      </div>
      </form:form> 
      	
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

		
	</div>
	<!-- Avaa Modal valikko, mikäli muokkauskentässä on virheitä -->
	<c:if test="${avaaModal != null }">
		<script src="<%=request.getContextPath()%>/resources/js/modalAvaus.js"></script>
	</c:if>

</body>

</html>