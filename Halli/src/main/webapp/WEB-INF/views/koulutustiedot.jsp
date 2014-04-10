<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

<div class="panel panel-default">
  <!-- Default panel contents -->
  
  <div class="panel-heading">${koulutus.kt.aihe}</div>
  
  <div class="panel-body">    
    <p>${koulutus.kt.kuvaus}</p>    
  </div>

  <!-- Table -->
  <table class="table">
  
  <tr>
    	<th>Päivämäärä</th>
    	<td>${koulutus.pvm}</td> 
    </tr>
  	
  	<tr> 
  		<th>Alkaa</th>
  		<td>${koulutus.alkukello} </td>
  	</tr>
  	
  	<tr>  	
		<th>Loppuu</th>	  
	    <td>${koulutus.loppukello}</td>    
    </tr>
    
    <tr>
    	<th>Koulutustila</th>
    	<td>${koulutus.koulutustila}</td> 
    </tr>
    
    <tr>
    	<th>Lähtötaso</th>
    	<td>${koulutus.lahtotaso}</td> 
    </tr>
    
    <tr>
    	<th>Näkyvyys</th>
    	<td>${koulutus.nakyvyys}</td> 
    </tr>
    
  </table>
</div>



	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>