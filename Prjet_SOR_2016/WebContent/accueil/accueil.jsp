<%@page import="validation.Identification"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />
	
<jsp:useBean id="validation" 
	class="validation.Validation"
	scope="request" />
    
    
<%

if (request.getParameter("submit") != null) {
	if(validation.nonVide(Identification.class, "id", request.getParameter("id")) && 
			validation.estEntier(Identification.class, "id", request.getParameter("id"))){
		if(validation.estCorrect(Identification.class, "id", request.getParameter("id"))){
			int num = Integer.parseInt(request.getParameter("id"));
			//connexion
			if(manager.getServRMI().isValideCode(num)){
				manager.setIdentifie(true);
				manager.setNum(num);
				//Admin ?
				if(manager.getServRMI().isAdmin(num)){
					manager.setAdmin(true);
				}
				response.sendRedirect("../accueil/accueil.jsp");
				return;
			}
		}
	}
}
%>    
       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brest 2016</title>
</head>
<body>
<jsp:include page="../commun_page_menu/menu.jsp" />




<h1>Accueil</h1>

<c:if test="${manager.identifie && !manager.admin}">
<p>Bonjour ${manager.num}, vous êtes connecté en tant que visiteur</p>
</c:if>

<c:if test="${manager.identifie && manager.admin}">
<p>Bonjour ${manager.num}, vous êtes connecté en tant qu'administrateur</p>
</c:if>


<c:if test="${!manager.identifie}">
<p>Bonjour étranger</p>

<h1>Identification</h1>

<form>
	<table>
		<tr>
			<td>Clef secrete : </td>
			<td><input type="text" 
						value= "${validation.valeurs['id']}"
						name="id"/></td>
			<td>${validation.erreurs['id']}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit"
				value="Valider"
				name="submit" /></td>
		</tr>
	</table>
</form>



</c:if>

</body>
</html>