<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation animation</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />

<h1>Ajouter une animation</h1>

<form>
	<table>
		<tr>
			<td>Nom : </td>
			<td><input type="text" 
						value= "${validation.valeurs['nom']}"
						name="nom"/></td>
			<td>${validation.erreurs['ident']}</td>
		</tr>
		<tr>
			<td>Description : </td>
			<td><input type="text" 
						value= "${validation.valeurs['desc']}"
						name="desc"/></td>
			<td>${validation.erreurs['mdp']}</td>
		</tr>
		<tr>
			<td>Image : </td>
			<td><input type="text" 
						value= "${validation.valeurs['img']}"
						name="img"/></td>
			<td>${validation.erreurs['img']}</td>
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
						value= "${validation.valeurs['nb_place']}"
						name="nb_place"/></td>
			<td>${validation.erreurs['nb_place']}</td>
		</tr>
		<tr>
			<td>groupe : </td>
			<td>
				<select name="thelist">
				<%
				
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
			<td>&nbsp;</td>
			<td><input type="submit"
				value="Valider"
				name="submit" /></td>
		</tr>
	</table>
</form>


</body>
</html>