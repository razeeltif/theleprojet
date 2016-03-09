<%@page import="Bean.Animation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" /> 

<%
/*
//création objet persistant
//equivalent jsp:useBean
Manager manager = (Manager)request.getSession().
	getAttribute("manager");
if (manager == null) {
	// si objet persistant pas encore créé
	manager = new Manager();
	request.getSession().setAttribute(
			"manager", manager);
}

*/

if (request.getParameter("submit") != null) {
	validation.nonVide(Animation.class, "nom", request.getParameter("nom"));
	validation.nonVide(Animation.class, "description", request.getParameter("description"));
//	validation.nonVide(Animation.class, "groupe", request.getParameter("groupe"));
	
	if (validation.isValide()) {
		String nom = validation.getValeurs().get("nom");
		String description = validation.getValeurs().get("description");
		
		/*verif si nom_groupe existe deja
		* getGroupe(nom) == null
		*/
		
		/*ajout de l'aniamtion � la BDD 
			manager.getServRMI().addGroupe(nom, description);
		*/
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