<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="manager.Manager"%>

<%
Manager manager = (Manager)request.getSession().getAttribute("manager");
if(manager!=null){
	manager.setIdentifie(false);
	manager.setAdmin(false);
	manager.setNum(-1);
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta HTTP-EQUIV="REFRESH" content="0; url=../accueil/accueil.jsp">
<title>Déconnexion</title>
</head>
<body>


</body>
</html>