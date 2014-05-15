<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>

<html lang="fi">
<head>

<meta charset="utf-8">

<title>Halli</title>
<meta name="description"
	content="Halli: Koulutusten hallinta- ja ilmoittautumisjärjestelmä">
<meta name="author" content="Haaga-Helia">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/hallityylit.css">

<!--[if lt IE 9]>
            <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->
</head>

<body>
	<div class="container">
		<div class="sivumenu">
			<a href="./">
			
			<c:if test="${tulevatValittu != null}">
				<div class="nav-item aktiivinen">
			</c:if>
			<c:if test="${tulevatValittu == null}">
					<div class="nav-item"/>
			</c:if>
					<div class="nav-icon tulevat"></div>
					<div class="nav-text">Tulevat luennot</div>
				</div>
			</a> <a href="./menneet">
			<c:if test="${menneetValittu != null}">
				<div class="nav-item aktiivinen">
			</c:if>
			<c:if test="${menneetValittu == null}">
					<div class="nav-item"/>
			</c:if>
					<div class="nav-icon menneet"></div>
					<div class="nav-text">Menneet luennot</div>
				</div>
			</a>
			<a href="" data-toggle="modal"
			data-target="#opiskelijanumeroModal"><div class="nav-item">
				<div class="nav-icon palaute"></div>
				<div class="nav-text">Anna palautetta</div>
			</div></a>
		</div>
		<div class="modal fade bs-example-modal-sm" tabindex="-1"
				role="dialog" aria-labelledby="opiskelijanumeroModal" aria-hidden="true" id="opiskelijanumeroModal">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<form action="anna_palautetta" id="opiskelijanumeroForm"
							method="post">
							<br>
							<label for="opiskelijanumero" style="color:grey;">Anna opiskelijanumerosi</label>
							<br>
							<input type="text" id="opiskelijanumero" name="opiskelijanumero"
								placeholder="a1234567" class="form-control" maxlength="8" />
							<br>
							<input type="submit" value="Jatka" class="form-control btn btn-primary"></input>
						</form>
					</div>
				</div>
		</div>
		<div class="main clearfix">
		<div class="ylapalkit">
			<div class="yla1">Halli: Koulutusten hallinta- ja
				ilmoittautumisjärjestelmä</div>
			<div class="yla2"><div class="yla2-icon admin"></div><a href="./admin">Kirjaudu sisään järjestelmänvalvojana</a></div>
		</div>
			<div class="fifty lista">
				<form id="haku" action="hakutulokset">
					<input type="text" name="haku" autocomplete="off"
						placeholder="Suodata koulutuksia hakusanan perusteella"
						value="${hakusana}"><input type="submit" value=" "><c:if test="${!empty hakusana}"><c:out escapeXml="false" value="<a class='sulkemisnappi' href='./'></a>" /></c:if>
				</form>
				<ul>
					<c:if test="${empty koulutukset}">
						<c:out value="Koulutuksia ei löytynyt hakusanan perusteella" />
					</c:if>
					<c:forEach items="${koulutukset}" var="k">
						<li divid="<c:out value="${k.id}"/>" class="aihe"><input
							type="checkbox" name="box" class="box" value="${k.id}" id="checkboxi" disabled />
							<label for="checkboxi"></label>
							<c:out value="${k.aihe}" /> <span class="pvm"><c:out
									value="${k.suomiPvm}" /></span></li>
					</c:forEach>
				</ul>
			</div>
			<div class="fifty tiedot">
				<div class="table-container">
							<span
								style="display: block; text-align: center; margin-top: 96px; margin-bottom: 96px;">Tervetuloa
								HAAGA-HELIA ammattikorkeakoulun ilmoittautumisjärjestelmään!
								Tarvitset opiskelijatunnuksen. Valitse koulutukset vasemmalta.</span>
							<br />
				</div>
				<c:forEach items="${koulutukset}" var="k">
					<input type="hidden" name="aihe" value="${k.aihe}" />
					<div class="table-container" id="<c:out value="${k.id}"/>"
						style="display: none">
						<table>
							<tr>
								<td class="koulutus-otsikko" colspan="2">Koulutuksen tiedot</td>
							</tr>
							<tr>
								<td style="width:1px;" class="bold">Aihe</td>
								<td><c:out value="${k.aihe}" /></td>
							</tr>
							<tr>
								<td class="bold">Kouluttajat</td>
								<td><c:forEach items="${k.kouluttajat}" var="koul"
										varStatus="loopStatus">
										<c:out value="${koul.etunimi} " />
										<c:out value="${koul.sukunimi}" />
										<c:if test="${!loopStatus.last}">
											<c:out value=", " />
										</c:if>
									</c:forEach></td>
							</tr>
							<tr>
								<td class="bold">Päivämäärä</td>
								<td><c:out value="${k.suomiPvm}" /></td>
							</tr>
							<tr>
								<td class="bold">Kellonaika</td>
								<td><c:out value="${k.suomiKlo}" /> - <c:out
										value="${k.suomiLoppuKlo}" /></td>
							</tr>
							<tr>
								<td class="bold">Avainsanat</td>
								<td><c:forEach items="${k.avainsanat}" var="a">
										<span class="tagi"><a href="avainsana?avainsana=${a}"
											class="tagi"><c:out value="${a}" /></a></span>
									</c:forEach></td>
							</tr>
							<tr>
								<td class="bold">Lähtötaso</td>
								<td><c:out value="${k.lahtotaso}" /></td>
							</tr>
							<tr>
								<td class="bold">Paikka</td>
								<td><c:out value="${k.paikka}" /></td>
							</tr>
							<tr>
								<td class="bold">Kuvaus</td>
								<td><p>
										<c:out value="${k.kuvaus}" />
									</p></td>
							</tr>
							
							<jsp:useBean id="now" class="java.util.Date" />
							<fmt:parseDate value="${k.suomiPvm}" pattern="dd.MM.yyyy"
								var="pvm" />
							<fmt:formatDate value="${pvm}" pattern="yyyy-MM-dd" var="pvm" />
							<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="nyt" />
							<tr>
								<td></td>
								<td><c:choose>
										<c:when test="${pvm > nyt}">
											<button type="button" value="${k.id}" class="lisaa">Valitse
												koulutus</button>
										</c:when>
										<c:otherwise>
											<p>Menneille luennoille ei ole mahdollista ilmoittautua</p>								
										</c:otherwise>
									</c:choose></td>
							</tr>
							</table>
					</div>
				</c:forEach>
			</div>
			<div class="alapalkki">
			<c:choose>
				<c:when test="${pvm > nyt}">
				 <button type="submit" class="vahvistus" data-toggle="modal" data-target="#myModal" disabled>
				  Vahvista ilmoittautumiset
				</button>
				 
				</c:when>
			</c:choose>
			</div>
		</div>

	</div>

	<!-- lightboxin sisältö -->
	<!-- lightboxin sisältö päättyy -->
	
	<!-- Bootstrap Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Koulutuksiin ilmoittautuminen</h4>
      </div>
      <div class="modal-body">
        				<p>Olet valinnut seuraavat koulutukset:</p>

				<ul id="valitut"></ul>

				<p>Anna vielä tietosi ilmoittautumista varten:</p>

				
								<form id="ilmoittautuminen" method="post" action="ilmoittaudu"
					name="ilmoittaudu">
				
									<input type="hidden" id="valitutkoulutukset"
						name="valitutkoulutukset" />
<div class="row">
<div class="form-group col-xs-6">
<label for="sähköposti" class="bootstrap">Etunimi</label>
<input type="text" name="etunimi" class="form-control" id="sähköposti">
</div>
<div class="form-group col-xs-6">
<label for="sukunimi" class="bootstrap">Sukunimi</label>
<input type="text" name="sukunimi" class="form-control" id="sukunimi">
</div>
</div>
<div class="form-group">
<label for="opiskelijanumero" class="bootstrap">Opiskelijanumero</label>
<input type="text" name="opiskelijanro" class="form-control" id="opiskelijanumero" autocomplete="off">
</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Sulje ikkuna</button>
        				<button type="submit" class="btn btn-primary" id="ilmoittaudu" disabled>
					Ilmoittaudu koulutuksiin</button>
					
					</form>
      </div>
    </div>
  </div>
</div>

<div class="modal" id="kiitos">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Koulutuksiin ilmoittautuminen</h4>
      </div>
      <div class="modal-body">
        <p>Ilmoittautumisesi on vastaanotettu. Kiitos!</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Sulje ikkuna</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->		
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/additional-methods.js"></script>
	<script type="application/javascript"
		src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		
								<c:if test="${viesti!=null}">
						<script>$( document ).ready(function() {
							$('#kiitos').modal('show');
						});</script>
						</c:if>
</body>
</html>

