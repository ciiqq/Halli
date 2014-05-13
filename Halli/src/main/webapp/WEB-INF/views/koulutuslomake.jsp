<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Koulutuslomake</title>
    <!-- Styles -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<!-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">  -->


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
     <div class="container-fluid"> <!-- Sivun kehys -->
     <form:form  method="POST" modelAttribute="koulutustilaisuus">
        <div class="row"> <!-- Aihe ja ajankohta inputit alkaa -->
            <div class="col-xs-12 col-sm-8 col-md-8">
                <label>Koulutuksen aihe</label>
                <form:input class="form-control" path="aihe" placeholder="Anna aihe" maxlength="50"></form:input>
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-8"> 
                            <label>Kouluttajat</label>
                        </div> 
                    </div>
                    <div class="row">   
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <div class="">
                                <form:input id="kouluttaja0" class="form-control" disabled="true" path="kouluttajat[0]" ></form:input>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <form:input id="kouluttaja1" class="form-control" disabled="true" path="kouluttajat[1]"></form:input>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" data-toggle="modal" data-target="#kouluttajavalinta">+</button>
                                </span>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <form:input id="kouluttaja2" class="form-control" disabled="true" path="kouluttajat[2]"></form:input>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" data-toggle="modal" data-target="#kouluttajavalinta">+</button>
                                </span>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-4">
                <label>Ajankohta</label>
                    <div class="input-group">
                        <form:input class="form-control" disabled="true" path="aikaPaiva"></form:input>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" data-toggle="modal" data-target="#aikavalinta">Valitse aika</button>
                        </span>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-6"> 
                            <label>Ohjaaja</label>
                            <form:input class="form-control" disabled="true" path="ope"></form:input>                           
                        </div> 
                        <div class="col-xs-12 col-sm-8 col-md-6"> 
                            <label>Luokkatila</label>
                            <form:input class="form-control" disabled="true" path="paikka"></form:input>                           
                        </div> 
                    </div>
            </div>
        </div> <!-- Aihe ja ajankohtainputit loppuu --> 
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6"> 
                <label>Kuvaus</label>
                <form:textarea class="form-control" rows="4" cols="50" style="resize:none;" path="kuvaus"></form:textarea>                      
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6"> 
                <label>Koulutusmenetelmät</label>
                <form:textarea placeholder="Koulutuksessa käytettävät välineet ja menetelmät" class="form-control" rows="4" cols="50" style="resize:none;" path="koulutusmenetelmat"></form:textarea>                      
            </div> 
        </div>
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <label>Lähtötaso</label>
                <form:select class="form-control" style="resize:none;" path="lahtotaso">
  					<option>Helppo</option>
  					<option>Keskitaso</option>
  					<option>Vaikea</option>
 			</form:select>
            </div> 
             <div class="col-xs-6 col-sm-6 col-md-6">
                <label>Avainsanat</label>
                <form:textarea placeholder="Avainsanat pilkulla eroteltuina" class="form-control" rows="4" cols="50" style="resize:none;" path="avainsanat[0]"></form:textarea>
            </div> 
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <button class="btn btn-lg navbar-btn navbar-right" type="submit">Tallenna</button>               
            </div>
    </div>
    </form:form>
    
<!-- Aikavalinta ikkunan sisältö (Modal)-->
<div class="modal fade" id="aikavalinta" tabindex="-1" role="dialog" aria-labelledby="aikavalintaTitle" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="aikavalintaTitle">Valitse koulutuksen ajankohta</h4>
      </div>
    <form role="form">  
      <div class="modal-body">
            <div class="form-group">
                <table class="table">
                    <thead>
                    <th>Pvm</th>
                    <th>Alkuaika</th>
                    <th>Loppuaika</th>
                    <th>Luokkatila</th>
                    <tbody>
                        <c:forEach items="${vapaatajat}" var="aika" varStatus="status">
							<tr  class="ajankohta" style="cursor:pointer;" >
								<td><fmt:formatDate pattern="dd.MM.yyyy" value="${aika.pvm}" /></td>
								<td><c:out value="${aika.alkukello}"/></td>
								<td><c:out value="${aika.loppukello}"/></td>
								<td><c:out value="${aika.koulutustila}"/></td>
							</tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Peruuta</button>
        <button type="button" class="btn btn-primary">Valitse aika</button>
      </div>
    </form>
    </div>
  </div>
</div>

<!-- Kouluttajavalinta ikkunan sisältö (Modal)-->
<div class="modal fade" id="kouluttajavalinta" tabindex="-1" role="dialog" aria-labelledby="kouluttajavalintaTitle" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="aikavalintaTitle">Lisää kouluttaja koulutussuunnitelmaan</h4>
      </div>
    <form role="form">  
      <div class="modal-body">
            <div class="form-group">
                <table class="table">
                    <thead>
                    	<th></th>
                        <th>Etunimi</th>
                        <th>Sukunimi</th>
                    <tbody>
                        <!-- Varattu vapaiden samalla toteutuksella olevien opiskelijoiden listaukseen -->
						  <c:forEach items="${kouluttajat}" var="kouluttaja" varStatus="status">
							<tr class="kouluttaja" style="cursor:pointer;" >								
								<td><c:out value="${status.count}. " /></td>
								<td><c:out value="${kouluttaja.etunimi}"/></td>
								<td><c:out value="${kouluttaja.sukunimi}"/></td>
							</tr>
						</c:forEach>
                    </tbody>    
                </table>
            </div>
          
      </div>
      <div class="modal-footer">
        <input type="button"  class="btn btn-default" value="Peruuta" data-dismiss="modal"></input>
        <input type="button" id="lisaakouluttaja_nappula" class="btn btn-primary" value="Lisää kouluttaja" data-dismiss="modal"></input>
      </div>
    </form>
    </div>
  </div>
</div>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/koulutuslomake.js"></script>
</body>
</html>