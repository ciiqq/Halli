<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Testi</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <div class="navbar-brand">Halli</div>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="kouluttajien_lisays">Ensimmäinen</a>
                    </li>
                    <li>
                        <a href="#">Toinen</a>
                    </li>
                    <li>
                        <a href="#">Kolmas</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <a class="btn btn-primary" href="testaus/uusi">Testaa</a>
    </div>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    
    <a href="kouluttajat/">Kouluttajat</a>
</body>
</html>