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
<% Date paivays = new Date();
int kuukaudenEkaPaiva = 0;
int kuukaudenVikaPaiva = 0;
int ok,i,paiva,ekaloyty;
Calendar c = Calendar.getInstance();
c.setTime(paivays);
kuukaudenVikaPaiva=Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
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
	<table>
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
							<%= paiva %>
						<%	} else 
								ok=1;
					} %>
					</td>
				<% } %>
				</tr> 
			<% } %>
	
	</table>
</body>
</html>