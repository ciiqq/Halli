

<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>

<html lang="en">
<head>

<meta charset="utf-8">

<title>Halli</title>
<meta name="description"
	content="Halli: Koulutusten hallinta- ja ilmoittautumisjärjestelmä">
<meta name="author" content="Haaga-Helia">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/colorbox.css">

<!--[if lt IE 9]>
            <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->
</head>

<body>
	<div class="container">
		<div class="sivumenu">
			<a href="./">
			<div class="nav-item">
				<div class="nav-icon tulevat"></div>
				<div class="nav-text">Tulevat luennot</div>
			</div>
			</a>
			<a href="./menneet">
			<div class="nav-item">
				<div class="nav-icon menneet"></div>
				<div class="nav-text">Menneet luennot</div>
			</div>
			</a>
			<div class="nav-item">
				<div class="nav-icon palaute"></div>
				<div class="nav-text">Anna palautetta</div>
			</div>
		</div>
		<div class="main clearfix">
			<div class="ylapalkki">Halli: Koulutusten hallinta- ja
				ilmoittautumisjärjestelmä</div>
			<div class="fifty lista">
			<form id="haku" action="hakutulokset"><input type="text" name="haku" placeholder="Suodata koulutuksia hakusanan perusteella"><input type="submit" value=" "></form>
				<ul>
					<c:if test="${empty koulutukset}">
						<c:out value="Koulutuksia ei löytynyt" />
					</c:if>
					<c:forEach items="${koulutukset}" var="k">
						<li divid="<c:out value="${k.id}"/>" class="aihe"><input
							type="checkbox" name="box" class="box" value="${k.id}" disabled />
							<c:out value="${k.aihe}" /> <span class="pvm"><c:out
									value="${k.suomiPvm}" /></span></li>
					</c:forEach>
				</ul>
			</div>
			<div class="fifty tiedot">
				<div class="table-container" style="opacity:0.5;"><span style="display:block;text-align:center;margin-top:96px;margin-bottom:96px;">Valitse koulutus vasemmalta :)</span></div>
				<c:forEach items="${koulutukset}" var="k">
					<input type="hidden" name="aihe" value="${k.aihe}" />
					<div class="table-container" id="<c:out value="${k.id}"/>"
						style="display: none">
						<table>
							<tr>
								<td class="tiedotx" colspan="2">KOULUTUKSEN TIEDOT</td>
							</tr>
							<tr>
								<td class="bold">Aihe</td>
								<td><c:out value="${k.aihe}" /></td>
							</tr>
							<tr>
								<td class="bold">Kouluttajat</td>
								<td><c:forEach items="${k.kouluttajat}" var="koul" varStatus="loopStatus">
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
								<td><c:out value="${k.suomiKlo}" /> - <c:out value="${k.suomiLoppuKlo}" /></td>
							</tr>
							<tr>
								<td class="bold">Avainsanat</td>
								<td><c:forEach items="${k.avainsanat}" var="a">
										<span class="tagi"><a href="avainsana?avainsana=${a}" class="tagi"><c:out value="${a}" /></a></span>
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
								<td><p><c:out value="${k.kuvaus}" /></p></td>
							</tr>
							<tr>
								<td></td>
								<td><button type="button" value="${k.id}" class="lisaa">Valitse
										koulutus</button></td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</div>
			<div class="alapalkki">
				<button type="submit" name="vahvista" href="#lightbox_sisalto"
					class="vahvistus" disabled>Vahvista ilmoittautumiset</button>
			</div>
		</div>

	</div>

	<!-- lightboxin sisältö -->

	<div style='display: none'>
		<div id='lightbox_sisalto' style='padding: 20px; background: #fff;'>
			<div class="lightbox-inner-sisalto">
				<p>Olet valinnut seuraavat koulutukset:</p>
				<br />
				<ul id="valitut"></ul>
				<br />
				<p>Anna vielä tietosi ilmoittautumista varten:</p>
				<br />
				
				<form id="ilmoittautuminen" action="ilmoittaudu">
				
				<input type="hidden" id="valitutkoulutukset" name="valitutkoulutukset" />
				
				<table>
				  <tr>
				    <td>Etunimi</td>
				    <td>Sukunimi</td>
				  </tr>
				  <tr>
				    <td><input type="text" name="etunimi"></td>
				    <td><input type="text" name="sukunimi"></td>
				  </tr>
				  <tr>
				    <td colspan="2">Opiskelijanumero</td>
				  </tr>
				  <tr>
				    <td colspan="2"><input type="text" name="opiskelijanro"></td>
				  </tr>
				</table>
				</div>

<<<<<<< HEAD
			<div class="modal-controls clearfix">
				<button type="submit" value="ilmoittaudu"
					id="ilmoittaudu" disabled > Ilmoittaudu</button>
=======
			<div class="modaalin-kontrollit clearfix">
				<input type="submit" value="Ilmoittaudu koulutuksiin"
					id="ilmoittaudu" disabled /> 
>>>>>>> refs/remotes/origin/tiimi3-selailu-ilmoittautuminen
				<input type="button"
					onclick="$.colorbox.close()" value="Sulje ikkuna" />
			</div>
			</form>
		</div>
	</div>

	<!-- lightboxin sisältö päättyy -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.colorbox.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/additional-methods.js"></script>
	<script type="application/javascript"
		src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>
</html>

