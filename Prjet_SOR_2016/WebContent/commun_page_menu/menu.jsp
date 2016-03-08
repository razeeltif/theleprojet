<%@page import="manager.Manager"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<link type='text/css' href='../commun_page_menu/menu.css'	rel='stylesheet' />





<div id="menus">
	<div id="main-menu">
		<ul>
			<li class=" first"><a href="../accueil/accueil.jsp" title="Accueil">Accueil</a><span class="spacer"></span>
			</li>
			
			<c:if test="${manager.identifie}">
			<li class=" first"><a href="../animation/listerAnimation.jsp" title="Accueil">Animations</a><span class="spacer"></span>
				<ul>
					<li class="first"><a href="../animation/listerAnimation.jsp" title="liste des animation">Liste des animations</a>
					</li>
					<c:if test="${manager.identifie && manager.admin}">
					<li class="first"><a href="../animation/nouvelleAnimation.jsp" title="nouvelle animation">Creer une animation</a>
					</li>
					</c:if>
					<li class="first"><a href="../animation/nouvelleAnimation.jsp" title="nouvelle animation">Creer une animation</a>
					</li>
			</c:if>	
				
				</ul>
				</li>

				<c:if test="${manager.identifie && manager.admin}">
				<ul>
					<li class="first"><a href="../livre/enregistrerLivre.jsp" title="Enregistrer un livre">Enregistrer un livre</a>
						<ul>
							<li class=" first"><a href="../animation/nouvelleAnimation.jsp" title="Livres">Ajouter une réservation</a><span class="spacer"></span>
							</li>
						</ul>
					</li>
				</ul>
				</c:if>

			
			<c:if test="${manager.identifie && !manager.admin}">
			<li class=" first"><a href="../animation/nouvelleAnimation.jsp" title="Livres">Réservation</a><span class="spacer"></span>
			</li>
			</c:if>
			

			<c:if test="${manager.identifie}">
			<li class=" first"><a href="../identification/logout.jsp" title="Deconnexion">Déconnexion</a><span class="spacer"></span>
			</li>
			</c:if>
		</ul>
	</div>
</div>
