
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
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
</c:if>






</body>
</html>