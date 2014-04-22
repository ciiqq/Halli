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
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <div class="">
                                <input type="text" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" data-toggle="modal" data-target="#kouluttajavalinta">+</button>
                                </span>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" disabled>
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
                        <input type="text" class="form-control" disabled>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" data-toggle="modal" data-target="#aikavalinta">Valitse aika</button>
                        </span>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-6"> 
                            <label>Ohjaaja</label>
                            <input type="text" class="form-control" disabled>                           
                        </div> 
                        <div class="col-xs-12 col-sm-8 col-md-6"> 
                            <label>Luokkatila</label>
                            <input type="text" class="form-control" disabled>                           
                        </div> 
                    </div>
            </div>
        </div> <!-- Aihe ja ajankohtainputit loppuu --> 
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6"> 
                <label>Kuvaus</label>
                <textarea class="form-control" rows="4" cols="50" style="resize:none;"></textarea>                      
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6"> 
                <label>Oppimismenetelmät</label>
                <textarea class="form-control" rows="4" cols="50" style="resize:none;"></textarea>                      
            </div> 
        </div>
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <label>Lähtötaso</label>
                <textarea class="form-control" rows="4" cols="50" style="resize:none;"></textarea>
            </div> 
             <div class="col-xs-6 col-sm-6 col-md-6">
                <label>Avainsanat</label>
                <textarea class="form-control" rows="4" cols="50" style="resize:none;"></textarea>
            </div> 
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <button class="btn btn-lg navbar-btn navbar-right" type="button">Tallenna</button>               
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
        <button type="button" class="btn btn-primary">Lisää kouluttaja</button>
      </div>
    </form>
    </div>
  </div>
</div>

    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>