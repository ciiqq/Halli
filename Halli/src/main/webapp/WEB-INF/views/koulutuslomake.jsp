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
</head>
<body>
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
                                <form:input class="form-control" disabled="true" path="kouluttajat[0]"></form:input>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <form:input class="form-control" disabled="true" path="kouluttajat[1]"></form:input>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" data-toggle="modal" data-target="#kouluttajavalinta">+</button>
                                </span>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <form:input class="form-control" disabled="true" path="kouluttajat[2]"></form:input>
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
                <form:textarea class="form-control" rows="4" cols="50" style="resize:none;" path="lahtotaso"></form:textarea>
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
                    <th>Ohjaaja</th>
                    <th>Luokkatila</th>
                    <tbody>
                        <!-- Varattu vapaiden aikojen listaukselle-->
                        
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
                        <th>Opiskelija</th>
                    <tbody>
                        <!-- Varattu vapaiden samalla toteutuksella olevien opiskelijoiden listaukseen -->
                    </tbody>    
                </table>
            </div>
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Peruuta</button>
        <button type="button" class="btn btn-primary">Lis�� kouluttaja</button>
      </div>
    </form>
    </div>
  </div>
</div>

    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>