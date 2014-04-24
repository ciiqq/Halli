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
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modal.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modalmanager.js"></script>
<title>Koulutustiedot</title>
</head>
<body style="text-align: center; margin: 0 auto; width: 900px;">

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
<a type="button" class="btn btn-primary"  href="#test_modal" data-toggle="modal">Muokkaa</a>





<div class="modal fade" id="test_modal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
      <h3><c:out value="${ks.koulutus.aihe}" /></h3>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
        
        
        
        
        <%--  <form:form commandName="juuh" action="${pageContext.request.contextPath}/controllerinValue" method="POST">
          <form:input path="nimi"/> <form:errors path="nimi" />
          jne
          <input type="submit" value="Muokkaa koulutusta TMS??">
           </form:form>--%>
           
           <table class="table">
           
        <form:form modelAttribute="muokattavaKoulutus"  method="POST">
        
			  <tr>
			  	<th><form:label path="koulutus.aihe">Aihe</form:label></th>	 		  
			  	<td><form:input path="koulutus.aihe" value="${ks.koulutus.aihe}"/>  </td> 
			  	
			  </tr>  
			  
			  <tr>
			  	<th><form:label path="koulutus.kuvaus">Kuvaus</form:label></th>
			  	<td><form:input path="koulutus.kuvaus" value="${ks.koulutus.kuvaus}"/> </td>
			  	
			  </tr>    
			  
			  <tr>
			    <th><form:label path="pvm">Päivämäärä</form:label></th>
			  	<td><form:input path="pvm" value="${ks.pvm}"/> </td> 
			  </tr>
			  	
			  	<tr> 
			  		<th><form:label path="alkukello">Alkaa</form:label></th>
			  	<td><form:input path="alkukello" value="${ks.alkukello}"/></td> 
			  	</tr>
			  	
			  	<tr>  	
					<th><form:label path="loppukello">Loppuu</form:label></th>
			  		<td><form:input path="loppukello" value="${ks.loppukello}"/> </td>    
			    </tr>
			    
			    <tr>
			    	<th><form:label path="koulutustila">Koulutustila</form:label></th>
			  	<td><form:input path="koulutustila" value="${ks.koulutustila}"/></td> 
			    </tr>
			    
			    <tr>
			    	<th><form:label path="koulutus.lahtotaso">Lähtötaso</form:label></th>
			  	<td><form:input path="koulutus.lahtotaso" value="${ks.koulutus.lahtotaso}"/> </td> 
			    </tr>
			    
			    <tr>
			    	<th><form:label path="koulutus.nakyvyys">Näkyvyys</form:label></th>
			  	<td><form:input path="koulutus.nakyvyys" value="${ks.koulutus.nakyvyys}"/> </td> 
			    </tr>
			    
			    <div class="modal-footer">
			    <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
        	<button type="submit" class="btn btn-primary">Tallenna muutokset</button>
        	 </div>
			    
		</form:form>    
    
  </table>
      </div>
      
      	
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


</body>
</html>