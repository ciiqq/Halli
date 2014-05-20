<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE>
<html>
<head>
<title>Aikataulut</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/admintyylit.css">
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
					<li class="active"><a href="<%=request.getContextPath()%>/kouluttaja/koulutus">Koulutus</a></li>
					<li><a href="<%=request.getContextPath()%>/kouluttaja/palaute">Palaute</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<%=request.getContextPath()%>">Kirjaudu ulos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title">Lisää uusi koulutus</h2>
					</div>
					<div class="panel-body">
						<form:form  method="POST" id="koulutus_formi" modelAttribute="koulutustilaisuus">
        				<div class="row col-xs-12 col-sm-12 col-md-12">
        				    <div class="col-xs-12 col-sm-6 col-md-8">
        				    	<div class="form-group">
                               		<label>Koulutuksen aihe</label>
									<form:input class="form-control" id="aihe_input" path="aihe" placeholder="Anna koulutukselle aihe" maxlength="50"></form:input>
                				</div>
                				<div class="form-group">
                					<label>Kuvaus</label>
                					<form:textarea class="form-control" rows="5" cols="50" style="resize:none;" path="kuvaus" placeholder=""></form:textarea>                       
                				</div>
                				<div class="form-group">
                					<label>Koulutusmenetelmät</label>
									<form:textarea placeholder="Koulutuksessa käytettävät välineet ja menetelmät / koulutuksen kulku" class="form-control" rows="4" cols="50" style="resize:none;" path="koulutusmenetelmat"></form:textarea>                      
            				    </div>
            				    <div class="row">
            				    	<div class="col-xs-6 col-sm-4 col-md-4">
            				    		<div class="form-group">
            				        		<label>Lähtötaso</label>
                							<form:select id="lahtotaso_valinta" class="form-control" style="resize:none;" path="lahtotaso">            
  												<option>Helppo</option>
  												<option>Keskitaso</option>
  												<option>Vaikea</option>
 											</form:select>
 										</div>
 									</div>
 									<div class="col-xs-6 col-sm-8 col-md-8">
 										<div class="form-group">
                							<label>Avainsanat</label>
											<form:input placeholder="Avainsanat pilkulla eroteltuina" class="form-control" maxlength="50" path="avainsanat1[0]"></form:input>
            							</div>
            						</div> 
            					</div>
            				</div> 
                        	<div class="col-xs-12 col-sm-6 col-md-4">
                   				<label>Opiskelijanumero</label>
                       			<form:input id="kouluttaja_input" placeholder="Anna opiskelijanumerosi" class="form-control" path="kouluttajat1[0].opiskelijanro"></form:input>
                           		<form:hidden id="kouluttaja0" class="form-control" disabled="true" path="kouluttajat1[0].etunimi" ></form:hidden>     
								<label>Lisäkouluttajat</label>
                            	<div class="input-group">
                                	<form:input id="kouluttaja1_input" class="form-control" disabled="true" path=""></form:input>
                                	<span class="input-group-btn">
                                    	<input id="kouluttaja1_nappula" class="btn btn-default" type="button" value="+"/> <!-- data-toggle="modal" data-target=""/>-->
                                	</span>
                            	</div>
                            	<div class="input-group">
                                	<form:input id="kouluttaja2_input" class="form-control" disabled="true" path=""></form:input>
                                	<span class="input-group-btn">
                                    	<input id="kouluttaja2_nappula" class="btn btn-default" type="button" value="+" /> <!--  data-toggle="modal" data-target="">+</button>-->
                                	</span>
                            	</div>
                				<label>Ajankohta</label>
                        		<div class="input-group">
                        			<form:input id="ajankohta_input" class="form-control" disabled="true" path="aikaPaiva"></form:input>
                       				<span class="input-group-btn">
                            			<input id="aikavalinta_nappula" class="btn btn-default" type="button" value="Valitse"/> <!--  data-toggle="modal" data-target="#aikavalinta" value="Lisää ajankohta"/>-->
                        			</span>
                    			</div>
                            	<label>Ohjaaja</label>
                            	<form:input id="ohjaaja_input" class="form-control" disabled="true" path=""></form:input> <!-- Ei käytössä -->                           
                            	<label>Luokkatila</label>
                            	<form:input id="luokkatila_input" class="form-control" disabled="true" path="paikka"></form:input>                           		
									<div class="row col-xs-12 col-sm-12 col-md-12" style="color:#ffffff;-webkit-user-select: none;-moz-user-select: none;user-select: none;">.</div>
									<input class="btn btn-primary navbar-right" id="tallenna_nappula" type="submit" value="Tallenna"/>
							</div>
						</div>
       					</form:form>
           			</div>
				</div>
			</div>
		</div>
	</div>          
	
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
                		<table id="aikalistaus" class="table">
                    		<thead>
                    			<th>Pvm</th>
                    			<th>Alkuaika</th>
                    			<th>Loppuaika</th>
                    			<th>Luokkatila</th>
                    		</thead>
                    		<tbody>
                        		<c:forEach items="${vapaatajat}" var="aika" varStatus="status">
								<tr class="ajankohta" style="cursor:pointer;" >
									<td><c:out value="${aika.pvm}"/></td>
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
        			<input type="button" class="btn btn-default" value="Peruuta" data-dismiss="modal"></input>
        			<input type="button" id="valitseaika_nappula" class="btn btn-primary" value="Valitse aika" disabled data-dismiss="modal"></input>
      			</div>
    			</form>
    		</div>
  		</div>
	</div>

	<!-- Kouluttajavalinta ikkunan sisältö (Modal)-->
	<div class="modal fade" id="kouluttajavalinta1" tabindex="-1" role="dialog" aria-labelledby="kouluttajavalintaTitle" aria-hidden="true" data-backdrop="static">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        			<h4 class="modal-title" id="kouluttajavalintaTitle">Lisää kouluttaja koulutussuunnitelmaan</h4>
      			</div>
    			<form role="form">  
      			<div class="modal-body">
            		<div class="form-group">
                		<table class="table" id="kouluttajalistaus1">
                    		<thead>
                        		<th>Etunimi</th>
                        		<th>Sukunimi</th>
                       		</thead>
                    		<tbody>
						  		<c:forEach items="${kouluttajat}" var="kouluttaja" varStatus="status">
								<tr class="kouluttaja" style="cursor:pointer;" >								
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
        			<input type="button" id="lisaakouluttaja1_nappula" class="btn btn-primary" disabled value="Lisää kouluttaja" data-dismiss="modal"></input>
      			</div>
    			</form>
    		</div>
  		</div>
	</div>

	<!-- Kouluttajavalinta 2 ikkunan sisältö (Modal)-->
	<div class="modal fade" id="kouluttajavalinta2" tabindex="-1" role="dialog" aria-labelledby="kouluttajavalinta2Title" aria-hidden="true" data-backdrop="static">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        			<h4 class="modal-title" id="kouluttajavalintaTitle2">Lisää kouluttaja koulutussuunnitelmaan</h4>
      			</div>
    			<form role="form">  
   				<div class="modal-body">
            		<div class="form-group">
                		<table class="table" id="kouluttajalistaus2">
                			<thead>
                				<th>Etunimi</th>
                        		<th>Sukunimi</th>
                       		</thead>
                    		<tbody>
						  		<c:forEach items="${kouluttajat}" var="kouluttaja" varStatus="status">
								<tr class="kouluttaja" style="cursor:pointer;" >								
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
        			<input type="button" id="lisaakouluttaja2_nappula" class="btn btn-primary" disabled value="Lisää kouluttaja" data-dismiss="modal"></input>
      			</div>
    			</form>
    		</div>
  		</div>
	</div>

    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/koulutuslomake.js"></script>
</body>
</html>