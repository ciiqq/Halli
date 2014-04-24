<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

    
<!DOCTYPE>
<html>
<head>
<title>Kouluttajien lisäys</title>
</head>
<body>

<h1>Kouluttajien lisäys</h1>

<div>
	<form action="lisaaLista" method="post" enctype="multipart/form-data">
		<table>
		
		<tr>
			<td><input type="file" name="kouluttajaLista" /></td>
		</tr>
		
		<tr>
			<td><input type="submit" /></td>
		</tr>
		
		</table>
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

</body>
</html>