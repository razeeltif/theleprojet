<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Hashtable" %>
<%@page import="Bean.Groupe" %>
<%@page import="Bean.Animation" %>
<%@page import="Bean.Horaires" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" /> 

<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />  
	
<jsp:useBean id="listeHeure" 
	class="obj.ListeHeure"
	scope="session" />     
   
<%

if(request.getParameter("modif") != null){
	String nom = request.getParameter("modif");
	Animation anim = manager.getServRMI().getAnim(nom);
	
	String description = anim.getDescription();
	int duree = anim.getDuree();
	int nb_places = anim.getNb_Places();
	String photo = anim.getLien_photo();
	String groupe = anim.getGroupe_name();
	
	ArrayList<Horaires> listeHoraires = manager.getServRMI().getHoraires(nom);
	listeHeure.setNb(listeHoraires.size());

	for(int i = 0; i < listeHoraires.size(); i++){
		validation.getValeurs().put("heure"+i, Integer.toString(listeHoraires.get(i).getHeure_Debut()));
	}
	
	validation.getValeurs().put("nom", nom);
	validation.getValeurs().put("description", description);
	validation.getValeurs().put("duree", Integer.toString(duree));
	validation.getValeurs().put("nb_places", Integer.toString(nb_places));
	validation.getValeurs().put("photo", photo);
	validation.getValeurs().put("groupe", groupe);

}

if (request.getParameter("submit") != null) {
	
	validation.estEntier(Animation.class, "duree", request.getParameter("duree"));
	validation.estEntier(Animation.class, "nb_places", request.getParameter("nb_places"));
	
	validation.nonVide(Animation.class, "nom", request.getParameter("nom"));
	validation.nonVide(Animation.class, "description", request.getParameter("description"));
	validation.nonVide(Animation.class, "duree", request.getParameter("duree"));
	validation.nonVide(Animation.class, "nb_places", request.getParameter("nb_places"));
	validation.nonVide(Animation.class, "photo", request.getParameter("photo"));
	
	for(int i = 0; i < listeHeure.getNb(); i++){
		validation.estEntier(Animation.class, "heure"+i, request.getParameter("heure"+i));
		validation.nonVide(Animation.class, "heure"+i, request.getParameter("heure"+i));
	}
	
	if (validation.isValide()) {
		
		String nom = validation.getValeurs().get("nom");
		String description = validation.getValeurs().get("description");
		int duree = Integer.parseInt(request.getParameter("duree"));
		int nb_places = Integer.parseInt(request.getParameter("nb_places"));
		String photo = validation.getValeurs().get("photo");
		String nom_groupe = request.getParameter("groupe");
		
		/*verif si nom_groupe existe deja */
		String res =null;
		Animation anim = manager.getServRMI().getAnim(nom);
		if(anim != null){
			res = anim.getNom_animation();
		}
		if(validation.existePas(Groupe.class,"nom", res)){
			//ajout dans la BDD
			manager.getServRMI().addAnim(nom, description, photo, duree, nb_places, nom_groupe);
			for(int i = 0; i < listeHeure.getNb(); i++){
				int h = Integer.parseInt(request.getParameter("heure"+1));
				manager.getServRMI().createHorairesAnimation(nom_groupe, h);
			}
			validation.setMessValid("L'animation a été créée");
			validation.setValeurs(new Hashtable<String,String>());
			validation.setErreurs(new Hashtable<String,String>());
			
			//response.sendRedirect("../animation/nouvelleAnimation.jsp");
			//return;	
		}			
	}
	System.out.println("vals : "+validation.getValeurs());
	System.out.println("errs : "+validation.getErreurs());
}

if (request.getParameter("+") != null) {
	listeHeure.setNb(listeHeure.getNb() + 1);
}
if (request.getParameter("-") != null) {
	if(listeHeure.getNb() > 0){
		listeHeure.setNb(listeHeure.getNb() - 1);
	}
}

System.out.println(listeHeure.getNb());

%>  
    
        
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brest 2016</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Ajouter une animation</h1>

<form<%if(request.getParameter("modif") != null) out.println("action=\"nouvelleAnimation.jsp?modif="+validation.getValeurs().get("nom")+"\""); %>> <!-- action="UploadServlet" method="post" enctype="multipart/form-data" -->
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
				<select name="groupe" >
				<%
				ArrayList<Groupe> groupe = manager.getServRMI().getAllGroupe();
				Iterator<Groupe> itr = groupe.iterator();
			      while(itr.hasNext()) {
			        Groupe element = itr.next();
			        if(validation.getValeurs().get("groupe") != null){
			        	out.print("<option selected>");
			        }else{
						out.print("<option>");
			        }
					out.println(element.getNom_groupe());
					//out.println("</option>");
			      }
				%>

				</select>
			</td>
			<td>${validation.erreurs['groupe']}</td>
		</tr>
		

		
		<tr>
			<td>heure : </td>
			<table>
				
				
			<%
			for(int i = 0; i < listeHeure.getNb(); i++){
				//champs texte pour heure
				out.println("<tr><td><input type=\"text\" value= \"");
				if(validation.getValeurs().get("heure"+i) != null){
					out.println(validation.getValeurs().get("heure"+i));
				}
				out.println("\" name=\"heure"+i+"\"/></td><td>");
				if(validation.getErreurs().get("heure"+i) != null){
					out.println(validation.getErreurs().get("heure"+i));
				}
				out.println("</td></tr>");
			}
			
			%>
			</table>
			
		<tr>
			<td><input type="submit" value="+" name="+" /></td>
			<td><input type="submit" value="-" name="-" /></td>
		</tr>
		<tr>
			<td>image :</td>
			<td><input type="file" value="${validation.valeurs['photo']}" size="35" name="photo"/></td>
			<td>${validation.erreurs['photo']}</td>
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