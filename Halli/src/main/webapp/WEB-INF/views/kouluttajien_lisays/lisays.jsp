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
	<form action="" method="post">
		<table>
		
		<tr>
			<td><input type="file" name="kouluttaLista" /></td>
		</tr>
		
		<tr>
			<td><input type="submit" /></td>
		</tr>
		
		</table>
	</form>
</div>



<div>
	<form:form modelAttribute="kouluttaja" method="post">
		  	<fieldset>		
				<legend>Kouluttajan tiedot</legend>
				<p>
					<form:label	path="etunimi">Etunimi</form:label><br/>
					<form:input path="etunimi" />		
				</p>
				<p>	
					<form:label path="sukunimi">Sukunimi</form:label><br/>
					<form:input path="sukunimi" />
				</p>
				<p>	
					<form:label path="opiskelijanro">Opiskelijanumero</form:label><br/>
					<form:input path="opiskelijanro" />
				</p>
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>
</div>

</body>
</html>