<%@page import="java.util.ArrayList"%>
<%@page import="manager.Manager"%>
<%@page import="Bean.Groupe"%>





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lister les groupes</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Liste des groupes</h1>
<%
	
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		ArrayList <Groupe>lst = manager.getServRMI().getAllGroupe();
		if(lst.size() > 0){
		out.println("<ul>");
		for (Groupe l : lst) {
			out.println("<li>"+l.getNom_groupe()+"</li>");
		}
		out.println("</ul>");
		}else{
			out.println("<p>Il n'existe aucun groupe</p>");
		}
	
	
%>

</body>
</html>