<%@page import="Bean.Animation"%>
<%@page import="Bean.Reservation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type='text/css' href='./listerReservation.css'	rel='stylesheet' />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vos reservations</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Vos reservations</h1>
<%
	
	ArrayList <Reservation>lst = manager.getServRMI().getResa(manager.getNum());
	out.println("<ul>");
	out.println("<li>");
	out.println("<table>");
	out.println("<thead><tr><th>Nom</th><th>Description</th><th>Duree</th><th>heure de début</th></tr></thead>");
	for (Reservation l : lst) {
		if(manager.getNum() == l.getCode_Billet()){
			
			String description = manager.getServRMI().getAnim(l.getNom_Animation()).getDescription();
			int duree = manager.getServRMI().getAnim(l.getNom_Animation()).getDuree();
			
			out.println("<tr>");
			out.println("<td>"+l.getNom_Animation()+"</td>");
			out.println("<td>"+description+"</td>");
			out.println("<td>"+duree+"</td>");
			out.println("<td>"+l.getTime()+"</td>");

		}

		
	}
	out.println("</table>");
	out.println("</li>");
	out.println("</ul>");
	
	
	
%>

</body>
</html>