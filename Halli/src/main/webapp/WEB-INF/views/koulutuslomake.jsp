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
    	<form class="form" action="./koulutuslomake.jsp" method="post" id="KoulutusForm" role="form">
        <div class="row"> <!-- Aihe ja ajankohta inputit alkaa -->
            <div class="col-xs-12 col-sm-8 col-md-8">
                <label>Koulutuksen aihe</label>
                <input type="text" class="form-control" placeholder="Anna koulutuksen aihe">
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-8"> 
                            <label>Kouluttajat</label>
                        </div> 
                    </div>
                    <div class="row">   
                        <div class="col-xs-12 col-sm-12 col-md-4">
                            <div class="">
                                <input type="text" class="form-control" disabled placeholder="Nimi sessiosta">
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">+</button>
                                </span>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">+</button>
                                </span>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-4">
                <label>Ajankohta</label>
                    <div class="input-group">
                        <input type="text" class="form-control" disabled>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" data-toggle="modal" data-target="#aikavalinta">Valitse aika</button>
                        </span>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-6"> 
                            <label>Ohjaaja</label>
                            <input type="text" class="form-control" disabled placeholder="Matti Meikalainen">                           
                        </div> 
                        <div class="col-xs-12 col-sm-8 col-md-6"> 
                            <label>Luokkatila</label>
                            <input type="text" class="form-control" disabled placeholder="Matti Meikalainen">                           
                        </div> 
                    </div>
            </div>
        </div> <!-- Aihe ja ajankohtainputit loppuu --> 
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6"> 
                <label>Kuvaus</label>
                <textarea class="form-control" rows="4" cols="50"></textarea>                      
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6"> 
                <label>Oppimismenetelmat</label>
                <textarea class="form-control" rows="4" cols="50"></textarea>                      
            </div> 
        </div>
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <label>Lahtotaso</label>
                <textarea class="form-control" rows="4" cols="50"></textarea>
            </div> 
             <div class="col-xs-6 col-sm-6 col-md-6">
                <label>Avainsanat</label>
                <textarea class="form-control" rows="4" cols="50"></textarea>
            </div> 
        </div>
        <div class="row">
        	<div class="col-xs-12 col-sm-12 col-md-12">
            	<button class="btn btn-default" type="button">Tallenna</button>
            </div> 
        </div>
        </form>
    </div>

<!-- Aikavalinta ikkunan sisältö -- ei vielä käytössä
<div class="modal fade" id="aikavalinta" tabindex="-1" role="dialog" aria-labelledby="aikavalintaLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="aikavalintaLabel">Modal title</h4>
      </div>
      <div class="modal-body">
       Testimodi
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
-->
    <script src="css/js/jquery-1.11.0.min.js"></script>
    <script src="css/js/bootstrap.min.js"></script>
</body>
</html>