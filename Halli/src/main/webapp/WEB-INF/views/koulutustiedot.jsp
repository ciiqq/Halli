<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-modal.css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modal.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-modalmanager.js"></script>
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

<a type="button" class="btn" style="width:100%;" href="#test_modal" data-toggle="modal">Muokkaa</a>

<div class="modal fade" id="test_modal">
  <div class="modal-header">
    <a class="close" data-dismiss="modal">&times;</a>
    <h3><c:out value="${ks.koulutus.aihe}" /></h3>
  </div>
  <div class="modal-body">
    <p>Test Modal</p>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal">Close</a>
    <a href="#" class="btn btn-primary">Save Changes</a>
  </div>
</div>

</body>
</html>