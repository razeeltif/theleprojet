<%@page import="obj.Animation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />
	
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" /> 
   
   
    
    
<%
/*
//crÃ©ation objet persistant
//equivalent jsp:useBean
Manager manager = (Manager)request.getSession().
	getAttribute("manager");
if (manager == null) {
	// si objet persistant pas encore crÃ©Ã©
	manager = new Manager();
	request.getSession().setAttribute(
			"manager", manager);
}

*/

if (request.getParameter("submit") != null) {
	validation.nonVide(Animation.class, "nom", request.getParameter("nom"));
	validation.nonVide(Animation.class, "description", request.getParameter("description"));
	validation.nonVide(Animation.class, "photo", request.getParameter("photo"));
	validation.nonVide(Animation.class, "nb_places", request.getParameter("nb_places"));
	validation.nonVide(Animation.class, "heure", request.getParameter("heure"));
	validation.nonVide(Animation.class, "duree", request.getParameter("duree"));
	validation.estEntier(Animation.class, "duree", request.getParameter("duree"));
//	validation.nonVide(Animation.class, "groupe", request.getParameter("groupe"));
	
	if (validation.isValide()) {
		String ident = validation.getValeurs().get("ident");
		String mdp = validation.getValeurs().get("mdp");
		
		/*ajout de l'aniamtion à la BDD 
			manager.getServRMI().ajouterAnimation();
		*/

			return;
		
				
	}
}

%>    
    
    
    
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation animation</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Ajouter une animation</h1>

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
			<td>heure : </td>
			<td><input type="text" 
						value= "${validation.valeurs['heure']}"
						name="heure"/></td>
			<td>${validation.erreurs['heure']}</td>
		</tr>
		<tr>
			<td>durée : </td>
			<td><input type="text" 
						value= "${validation.valeurs['duree']}"
						name="duree"/></td>
			<td>${validation.erreurs['duree']}</td>
		</tr>
		<tr>
			<td>nombre de places : </td>
			<td><input type="text" 
						value= "${validation.valeurs['nb_places']}"
						name="nb_places"/></td>
			<td>${validation.erreurs['nb_places']}</td>
		</tr>
		<tr>
			<td>groupe : </td>
			<td>
				<select name="thelist" >
				<%
				/*ArrayList<String> groupe = manager.gerServRMI().getListGroupe();
				* Iterator itr = al.iterator();
			      while(itr.hasNext()) {
			         String element = itr.next();
					out.println("<option>");
					out.println(element);
					out.println("</option>");
			      }
				*/
				
				for(int i = 0; i < 5; i++){
				out.println("<option>");
				
				out.println(i);
				
				out.println("</option>");
				}
				
				
				%>

				</select>
			</td>
			<td>${validation.erreurs['groupe']}</td>
		</tr>
		
		<tr>
			<td>image :</td>
			<td><input type="file" name="${validation.valeurs['photo']}" size="35" name="photo"/>
				<br />
			</td>
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