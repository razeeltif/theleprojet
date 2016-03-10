<%@page import="Bean.Animation"%>
<%@page import="Bean.Groupe"%>
<%@page import="manager.Manager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" /> 
	
<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />

<%

if (request.getParameter("submit") != null) {
	validation.nonVide(Groupe.class, "nomGroupe", request.getParameter("nomGroupe"));
	validation.nonVide(Groupe.class, "descriptionGroupe", request.getParameter("descriptionGroupe"));
	
	if (validation.isValide()) {
		String nom = validation.getValeurs().get("nomGroupe");
		String description = validation.getValeurs().get("descriptionGroupe");
		
		/*verif si nom_groupe existe deja */
		String res =null;
		Groupe groupe = manager.getServRMI().getGroupe(nom);
		if(groupe != null){
			res = groupe.getNom_groupe();
		}
		System.out.println(res);
		if(validation.existePas(Groupe.class,"nomGroupe", res)){
			manager.getServRMI().addGroupe(nom, description);
			//response.sendRedirect("../groupe/nouveauGroupe.jsp");
			validation.setMessValid("Le groupe a été créé");
			//return;	
		}			
	}
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brest 2016</title>
</head>
<body>

<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Ajouter un groupe</h1>

<form> <!-- action="UploadServlet" method="post" enctype="multipart/form-data" -->
	<table>
		<tr>
			<td>Nom : </td>
			<td><input type="text" 
						value= "${validation.valeurs['nomGroupe']}"
						name="nomGroupe"/></td>
			<td>${validation.erreurs['nomGroupe']}</td>
		</tr>
		<tr>
			<td>Description : </td>
			<td><input type="text" 
						value= "${validation.valeurs['descriptionGroupe']}"
						name="descriptionGroupe"/></td>
			<td>${validation.erreurs['descriptionGroupe']}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit"
				value="Valider"
				name="submit" /></td>
		</tr>
	</table>
</form>
<p>${validation.messValid}</p>

</body>
</html>