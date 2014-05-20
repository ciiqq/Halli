<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kalenteri</title>
</head>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>

<% Date paivays = (Date) request.getSession().getAttribute("paivays");
int kuukaudenEkaPaiva = 0;
int kuukaudenVikaPaiva = 0;
int ok,i,paiva,ekaloyty;
Calendar c = Calendar.getInstance();
c.setTime(paivays);
kuukaudenVikaPaiva=c.getActualMaximum(Calendar.DAY_OF_MONTH);
c.set(Calendar.DATE, 1);
kuukaudenEkaPaiva=c.get(Calendar.DAY_OF_WEEK);
ok=0;
if(kuukaudenEkaPaiva==1) { /* su ma ti ke to pe la -> ma ti ke to pe la su */
	kuukaudenEkaPaiva+=6;
} else {
	kuukaudenEkaPaiva-=1;
}

%>


<body>	

<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	<table>
	<form action="vaihdakuukausi" method="get">
	<tr>
	
 	<td><input type="submit" name="vaihda" value="edellinen"></td>
 	<td><input type="text" name="kuukausiteksti" value="${kuukausiteksti}"></td>
  	<td><input type="submit" name="vaihda" value="seuraava"></td>

	</tr>
	
	</form> 
	</table>
	
	
	<table>
	
	<form action="vaihdakuukausi" method="get">

		<tr>
		<td>ma</td>
		<td>ti</td>
		<td>ke</td>
		<td>to</td>
		<td>pe</td>
		<td>la</td>
		<td>su</td>
		</tr>
		<% ekaloyty=0; %>
		<% paiva=0; %>
		<% while(ok==0) { %>
				<tr>
				<% for(i = 1; i < 8; i+=1) { %> 
					<td>
					<% if(ekaloyty==0) {
						if(i==kuukaudenEkaPaiva)
							ekaloyty=1;
					}%>
					<% if(ekaloyty==1) {
							paiva++;
							if(paiva<=kuukaudenVikaPaiva) {
					%>
								<input type="submit" name="paiva" value="<%=paiva %>"></input>
						<%	} else 
								ok=1;
					} %>
					</td>
				<% } %>
				</tr> 
			<% } %>
	</form>
	</table>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
</html>