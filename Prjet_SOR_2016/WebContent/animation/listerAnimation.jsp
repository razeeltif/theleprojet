<%@page import="Bean.Animation"%>
<%@page import="Bean.Groupe"%>
<%@page import="Bean.Horaires"%>
<%@page import="validation.Identification"%>
<%@page import="manager.Manager"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />         

    
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" />    
      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../commun_page_menu/menu.jsp" />

<html>
<link type='text/css' href='./listeAnimation.css'	rel='stylesheet' />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brest 2016</title>
</head>
<body>




<h1>Liste des animations</h1>
<%
	ArrayList <Groupe>lstGroupe = manager.getServRMI().getAllGroupe();

out.println("<ul>");
for(Groupe elemGroupe : lstGroupe){	
	
	ArrayList <Animation>lst = manager.getServRMI().getAnimByGroupe(elemGroupe.getNom_groupe());
	if(lst.size() > 0){
	out.println("<li>");
	out.println("<table>");
	out.println("<caption>" + elemGroupe.getNom_groupe() + "</caption");
	out.println("<thead><tr><th>Nom</th><th>Description</th><th>Duree</th><th>Nombre de places</th></tr></thead>");
	for (Animation l : lst) {
		out.println("<tr>");
		out.println("<td>"+l.getNom_animation()+"</td>");
		out.println("<td>"+l.getDescription()+"</td>");
		out.println("<td>"+l.getDuree()+"</td>");
		out.println("<td>"+l.getNb_Places()+"</td>");
				if (manager.isIdentifie() && manager.isAdmin()) {
					//modification de l'animation
					out.println("<td class=\"end\"><input type=\"submit\" value=\"Modifier...\" name=\"submitModif\" /></td>");
				}

				ArrayList<Horaires> h = manager.getServRMI().getHoraires(l.getNom_animation());
				for (int i = 0; i < h.size(); i++) {
					out.println("<td>horaire : " + h.get(i).getHeure_Debut() + "</td>");
					if (manager.isIdentifie() && !manager.isAdmin()) {
						if (h.get(i).getNb_Places_dispo() > 0) {
							//ajout d'un bouton pour reserver
							out.println("<td class=\"end\"><input type=\"submit\" value=\"Reserver votre place !\" name=\"submitResa\" /></td>");
						} else {
							//ajout message plus de place
							out.println("<td class=\"end\">plus de places !</td>");
						}
					}
				}
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</li>");
		}

	}
	out.println("</ul>");
%>

<a href="../animation/genaratePDF.jsp" title="génération PDF">généner le PDF</a>


</body>

</html>