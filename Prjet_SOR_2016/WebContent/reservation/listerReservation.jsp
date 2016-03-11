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
	for (Reservation l : lst) {
		out.println("<li>"+l.getNom_Animation()+"</li>");
	}
	out.println("</ul>");
	
	
	
%>

</body>
</html>