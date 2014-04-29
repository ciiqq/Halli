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
                    <div class="side-menu">
                            <div class="nav-item">
                                    <div class="nav-icon"></div>
                                    <div class="nav-text">Tulevat luennot</div>
                            </div>
                            <div class="nav-item">
                                    <div class="nav-icon"></div>
                                    <div class="nav-text">Menneet luennot</div>
                            </div>
                            <div class="nav-item">
                                    <div class="nav-icon"></div>
                                    <div class="nav-text">Anna palautetta</div>
                            </div>
                    </div>
                    <div class="main clearfix">
                    <div class="top-bar">Halli: Koulutusten hallinta- ja ilmoittautumisjärjestelmä - VAHVISTAMATTOMAT KOULUTUKSET</div>
                            <div class="fifty list">
                            	<form id="koulutukset" action="vahvistakoulutus" method="POST" >
                                    <ul>
                                            <c:forEach items="${koulutukset}" var="k">
                                                    <li divid="<c:out value="${k.id}"/>" class="aihe"><input
                                                            type="checkbox" name="box" class="box" value="${k.id}" disabled />
                                                    <c:out value="${k.aihe}" /> <span class="pvm"><c:out
                                                                            value="${k.suomiPvm}" /></span></li>
                                            </c:forEach>
                                    </ul>
                                </form>
                            </div>
                            <div class="fifty details">
     
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
                            <button type="submit" name="vahvista" href="#" class="koulutuksienVahvistus" disabled>Vahvista ja julkaise valitut koulutukset</button>
                            <button type="submit" name="vahvistaKaikki" href="VahvistaKaikkiKoulutukset" class="kaikkienKoulutuksienVahvistus">Vahvista ja julkaise kaikki koulutukset</button>
            </div>
            </div>

            </div>

         <!-- lightboxin sisältö -->
			
			<div style='display:none'>
				<div id='lightbox_sisalto' style='padding:10px; background:#fff;'>
				<p>Olet valinnut seuraavat koulutukset:</p>
				<div id="valitut">
				</div>
				<br /><p>Anna vielä tietosi ilmoittautumista varten:</p>
				<form action="ilmoittaudu_koulutukseen" method="get">
				<table>
				<tr><td>Etunimi:</td><td><input type="text" name="etunimi"></td></tr>
				<tr><td>Sukunimi:</td><td><input type="text" name="sukunimi"></td></tr>
				<tr><td>Opiskelijanumero:</td><td><input type="text" name="opiskelijanro"></td></tr>
				<tr><td><input type="submit" value="Ilmoittaudu" /></td></tr>
				</table>
				</form>
				</div>
			</div>
			
		<!-- lightboxin sisältö päättyy -->
            <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
            <script src="<%=request.getContextPath()%>/resources/js/jquery.colorbox.js"></script>
            <script type="application/javascript" src="<%=request.getContextPath()%>/resources/js/script.js"></script>
    </body>
    </html>

