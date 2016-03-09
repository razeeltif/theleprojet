<%@page import="Bean.Animation"%>
<%@page import="Bean.Groupe"%>
<%@page import="manager.Manager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" /> 

<%


if (request.getParameter("submit") != null) {
	validation.nonVide(Animation.class, "nom", request.getParameter("nom"));
	validation.nonVide(Animation.class, "description", request.getParameter("description"));
	
	if (validation.isValide()) {
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		String nom = validation.getValeurs().get("nom");
		String description = validation.getValeurs().get("description");
		
		/*verif si nom_groupe existe deja */
		String res =null;
		Groupe groupe = manager.getServRMI().getGroupe(nom);
		if(groupe != null){
			System.out.println("YOLO");
			res = groupe.getNom_groupe();
		}
		System.out.println(res);
		if(res == null){
			manager.getServRMI().addGroupe(nom, description);
		}
		validation.existeDeja("nom", res);
		response.sendRedirect("../groupe/nouveauGroupe.jsp");
		return;
		
				
	}
}

%>        

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajouter groupe</title>
</head>
<body>

<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Ajouter un groupe</h1>

<form> <!-- action="UploadServlet" method="post" enctype="multipart/form-data" -->
	<table>
		<tr>
			<td>Nom : </td>
			<td><input type="text" 
						value= "${validation.valeurs['nom']}"
						name="nom"/></td>
			<td>${validation.erreurs['nom']}</td>
		</tr>
		<tr>
			<td>Description : </td>
			<td><input type="text" 
						value= "${validation.valeurs['description']}"
						name="description"/></td>
			<td>${validation.erreurs['description']}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit"
				value="Valider"
				name="submit" /></td>
		</tr>
	</table>
</form>


</body>
</html>