<%@page import="Bean.Animation"%>
<%@page import="validation.Identification"%>
<%@page import="manager.Manager"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" />         
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lister les animations</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Liste des animations</h1>
<%


		Manager manager = (Manager)request.getSession().getAttribute("manager");
		ArrayList <Animation>lst = manager.getServRMI().getAllAnim();
		if(lst.size() > 0){
			out.println("<ul>");
			for (Animation l : lst) {
				out.println("<li>"+l.getNom_animation());
				out.println("<ul>");
				out.println("<li>"+l.getDescription()+"</li>");
				out.println("</ul>");
				out.println("</li>");
				if(manager.isIdentifie() && !manager.isAdmin()){
					if(l.getNb_places_Restantes() > 0){
						//ajout d'un bouton pour reserver
						out.println("<input type=\"submit\" value=\"Reserver votre place !\" name=\"submit\" />");
					}else{
						//ajout message plus de place
						out.println("<li>plus de places !</li>");
					}
				}
			}
			out.println("</ul>");
		}else{
			out.println("<p>Il n'existe pas d'animation</p>");
		}
%>

</body>
</html>