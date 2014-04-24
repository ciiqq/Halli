<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-modal.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/koulutuslistaustyylit.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.4.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.timepicker.css">



<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.4.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.timepicker.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modal.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modalmanager.js"></script>

<script> 
 	$(document).ready(function() {
 		$( "#datepicker" ).datepicker({dateFormat: 'dd.mm.yy'});
 		$( ".timepicker" ).timepicker({ 'timeFormat': 'H:i', 
 			'minTime': '07:00',
 			'maxTime': '21:00'
 		});
 	});
 </script>

<!-- Avaa Modal valikko, mikäli muokkauskentässä on virheitä -->
<c:if test="${avaaModal != null }">
	<script src="<%=request.getContextPath()%>/resources/js/modalAvaus.js"></script>
</c:if>

<title>Koulutustiedot</title>
</head>


<body>


<div class="panel panel-default">
  <!-- Default panel contents -->
  
  <div class="panel-heading">${ks.koulutus.aihe}</div>
  
  <div class="panel-body">    
    <p>${ks.koulutus.kuvaus}</p>    
  </div>

  <!-- Table -->
  <table class="table">
  
  <tr>
    	<th>Päivämäärä</th>
    	<td>${ks.pvm}</td> 
    </tr>
  	
  	<tr> 
  		<th>Alkaa</th>
  		<td>${ks.alkukello} </td>
  	</tr>
  	
  	<tr>  	
		<th>Loppuu</th>	  
	    <td>${ks.loppukello}</td>    
    </tr>
    
    <tr>
    	<th>Koulutustila</th>
    	<td>${ks.koulutustila}</td> 
    </tr>
    
    <tr>
    	<th>Lähtötaso</th>
    	<td>${ks.koulutus.lahtotaso}</td> 
    </tr>
    
    <tr>
    	<th>Näkyvyys</th>
    	<td>${ks.koulutus.nakyvyys}</td> 
    </tr>
    
  </table>
</div>
<a class="btn btn-primary" href="../koulutuslistaus">Takaisin listaukseen</a>
<a id="muokkausPainike" type="button" class="btn btn-primary"  href="#test_modal" data-toggle="modal">Muokkaa</a><br /><br />


<!-- Jos muokkaus onnistui, näytetään käyttäjälle teksti siitä -->
<c:if test="${muokkausOnnistui != null}">
	<div id="mop" class="btn btn-success btn-lg">
		<c:out value="${muokkausOnnistui}" />
	</div>
</c:if>



<div class="modal fade" id="test_modal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
      <h3><c:out value="${ks.koulutus.aihe}" /></h3>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"><c:out value="${ks.pvm}" />, <c:out value="${ks.alkukello}" />-<c:out value="${ks.loppukello}" /></h4>
      </div>
       <form:form id="modal-form" modelAttribute="muokattavaKoulutus"  method="POST">
      <div class="modal-body">


           <table class="table">
      
        
			  <tr>
			  	<th><form:label path="koulutus.aihe">Aihe</form:label></th>	 		  
			  	<td><form:input path="koulutus.aihe" value="${ks.koulutus.aihe}"/>  </td> 
			  	<td><form:errors path="koulutus.aihe"></form:errors></td>
			  	
			  </tr>  
			  
			  <tr>
			  	<th><form:label path="koulutus.kuvaus">Kuvaus</form:label></th>
			  	<td><form:input path="koulutus.kuvaus" value="${ks.koulutus.kuvaus}"/> </td>
			  	<td><form:errors path="koulutus.kuvaus"></form:errors></td>
			  	
			  </tr>    
			  
			  <tr>
			    <th><form:label path="pvm">Päivämäärä</form:label></th>
			  	<td><form:input path="pvm" style="position: relative; z-index: 100000;" id="datepicker" value="${ks.pvm}"/> </td>
			  	<td><form:errors path="pvm"></form:errors></td> 
			  </tr>
			  	
			  <tr> 
			  	<th><form:label path="alkukello">Alkaa</form:label></th>
			  	<td><form:input path="alkukello" style="position: relative; z-index: 100000;" class="timepicker" value="${ks.alkukello}"/></td>
			  	<td><form:errors path="alkukello"></form:errors></td> 
			  </tr>
			  	
			  	<tr>  	
					<th><form:label path="loppukello">Loppuu</form:label></th>
			  		<td><form:input path="loppukello" class="timepicker" value="${ks.loppukello}"/> </td>    
			  		<td><form:errors path="loppukello"></form:errors></td>
			  </tr>
			    
			    <tr>
			    	<th><form:label path="koulutustila">Koulutustila</form:label></th>
			  	<td><form:input path="koulutustila" value="${ks.koulutustila}"/></td> 
			  	<td><form:errors path="koulutustila"></form:errors></td>
			    </tr>
			    
			    <tr>
			    	<th><form:label path="koulutus.lahtotaso">Lähtötaso</form:label></th>
			  	<td><form:input path="koulutus.lahtotaso" value="${ks.koulutus.lahtotaso}"/> </td>
			  	<td><form:errors path="koulutus.lahtotaso"></form:errors></td>
			    </tr>
			    
			    <tr>
			    	<th><form:label path="koulutus.nakyvyys">Näkyvyys</form:label></th>
			  	<td><form:input path="koulutus.nakyvyys" value="${ks.koulutus.nakyvyys}"/> </td> 
			  	<td><form:errors path="koulutus.nakyvyys"></form:errors></td>
			    </tr>
			    
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


</body>
</html>