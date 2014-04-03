<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<title>Koulutukset</title>
</head>
<body>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Koulutuslistaus</div>
  <div class="panel-body">
    <p>Koulutukset</p>
  </div>

  <!-- Table -->
  <table class="table">
  <tr>
  			<th>Päivämäärä</th>
  			<th>Aihe</th>
  			<th>Kuvaus</th>
  			<th>Lähtötaso</th>
  			<th>Alkaa kello</th>
  			<th>Loppuu kello</th>
  		</tr>
  
  <c:forEach var="slotti" items="${koulutukset}">
  		
		<tr>
			<td>
				${slotti.pvm}
			</td>
			
			<td>
				${slotti.koulutus.aihe}
			</td>
			<td>
				${slotti.koulutus.kuvaus}
			</td>
			<td>
				${slotti.koulutus.lahtotaso}
			</td>
			
			<td>
				${slotti.alkukello}
			</td>
			
			<td>
				${slotti.loppukello}
			</td>		
			
		
			<td>
				<input class="btn btn-primary" type="button" value="koulutukseen" name="${slotti.koulutus.id}">
			</td>
		</tr>
			
	</c:forEach>
   
  </table>
</div>



<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>



</body>
</html>