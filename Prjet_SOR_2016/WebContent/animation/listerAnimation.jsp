<%@page import="Bean.Animation"%>
<%@page import="Bean.Groupe"%>
<%@page import="validation.Identification"%>
<%@page import="manager.Manager"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" />
	
<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />         
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brest 2016</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Liste des animations</h1>
<%

ArrayList <Groupe>lstGroupe = manager.getServRMI().getAllGroupe();

out.println("<ul>");
for(Groupe elemGroupe : lstGroupe){	
	
	out.println("<li>"+elemGroupe.getNom_groupe());
	
	ArrayList <Animation>lst = manager.getServRMI().getAnimByGroupe(elemGroupe.getNom_groupe());
	out.println("<table>");
	for (Animation l : lst) {
		out.println("<tr>");
		out.println("<td>"+l.getNom_animation()+"</td>");
		out.println("<td>"+l.getDescription()+"</td>");
		out.println("<td>"+l.getDuree()+"</td>");
		out.println("<td>"+l.getNb_Places()+"</td>");
		if(manager.isIdentifie() && !manager.isAdmin()){
			if(/*l.getNb_places_Restantes()*/1 > 0){
				//ajout d'un bouton pour reserver
				out.println("<input type=\"submit\" value=\"Reserver votre place !\" name=\"submit\" />");
			}else{
				//ajout message plus de place
				out.println("<li>plus de places !</li>");
			}
		}
		out.println("<tr>");
	}
	out.println("<table>");	
	out.println("</li>");
	
}
out.println("</ul>");

%>


</body>

</html>