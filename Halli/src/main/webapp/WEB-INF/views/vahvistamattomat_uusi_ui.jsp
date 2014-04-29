<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
	<title>Koulutuksien vahvistus</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/colorbox.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
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
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="fifty list">
                            	<form id="koulutukset" action="vahvistakoulutus" method="POST" >
                                    <ul>
                                            <c:forEach items="${koulutukset}" var="k">
                                                    <li divid="<c:out value='${k.id}'/>" class="aihe"><input
                                                            type="checkbox" name="box" class="box" value="${k.id}" disabled />
                                                    <c:out value="${k.aihe}" /> <span class="pvm"><c:out value="${k.suomiPvm}" /></span></li>
                                            </c:forEach>
                                    </ul>
                                </form>
                        </div><div class="fifty details">
     
                                    <table id="Placeholder">
     
                                            <tr>
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                                    <br />
                                            </tr>
                                    </table>
     
                                    <c:forEach items="${koulutukset}" var="k">
                                    <input type="hidden" name="aihe" value="${k.aihe}"/>
                                            <table id="<c:out value="${k.id}"/>" style="display: none">
                                                    <tr>
                                                            <td class="bold">Nimi</td>
                                                            <td><c:out value="${k.aihe}" /></td>
                                                    </tr>
                                                    <tr>
                                                            <td class="bold">Kouluttajat</td>
                                                            <td><c:forEach items="${k.kouluttajat}" var="koul">
                                                                            <c:out value="${koul.etunimi} " />
                                                                            <c:out value="${koul.sukunimi} " />
                                                                    </c:forEach></td>
                                                    </tr>
                                                    <tr>
                                                            <td class="bold">Päivämäärä</td>
                                                            <td><c:out value="${k.suomiPvm}" /></td>
                                                    </tr>
                                                    <tr>
                                                            <td class="bold">Aika</td>
                                                            <td><c:out value="${k.suomiKloAlku}" /> - <c:out value="${k.suomiKloLoppu }" /></td>
                                                    </tr>
                                                    <tr>
                                                            <td class="bold">Avainsanat</td>
                                                            <td><c:forEach items="${k.avainsanat}" var="a">
                                                                            <span class="label label-primary"><c:out value="${a}" /></span>
                                                                    </c:forEach></td>
                                                    </tr>
                                                    <tr>
                                                            <td class="bold">Taso</td>
                                                            <td><c:out value="${k.lahtotaso}" /></td>
                                                    </tr>
                                                    <tr>
                                                            <td class="bold">Tila</td>
                                                            <td><c:out value="${k.paikka}" /></td>
                                                    </tr>
                                                    <tr>
                                                            <td class="bold">Kuvaus</td>
                                                            <td><c:out value="${k.kuvaus}" /></td>
                                                    </tr>
                                                    <tr>
                                                            <td></td>
                                                            <td><button type="button" value="${k.id}" class="vahvista">VAHVISTA
                                                                            KOULUTUS</button></td>
                                                    </tr>
                                            </table>
                                    </c:forEach>
                            </div>
                            <div class="bottom-bar">
                            <button type="submit" name="vahvista" href="#" class="btn btn-primary koulutuksienVahvistus" disabled>Vahvista ja julkaise valitut koulutukset</button>
                            <button type="submit" name="vahvistaKaikki" href="VahvistaKaikkiKoulutukset" class="btn btn-primary kaikkienKoulutuksienVahvistus">Vahvista ja julkaise kaikki koulutukset</button>
            				</div>
            				
            			Mitähän vittua?
						<div class="alert alert-danger">Ilmoitus!</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery.colorbox.js"></script>
    <script type="application/javascript" src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>
</html>