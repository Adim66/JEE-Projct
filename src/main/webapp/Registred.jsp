<%@ page import="CinemaJEE.com.cinema.entities.Compte" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%   Compte compte= ( Compte)  request.getAttribute("compte");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enregistrement Réussi</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-image:
		url('https://prod.cdn-medias.jeuneafrique.com/cdn-cgi/image/q=auto,f=auto,metadata=none,width=1800,fit=cover/https://prod.cdn-medias.jeuneafrique.com/medias/2018/12/21/3078493320_aa0a7ec1bd_b.jpg');
	background-size: cover; /* L'image couvre toute la page */
	background-position: center; /* Centre l'image */
	background-attachment: fixed;
	/* L'image reste fixe lors du défilement */
	margin: 0;
	padding: 0;
}

header.header {
	background-color: #4CAF50; /* Couleur de fond */
	color: white; /* Texte en blanc */
	padding: 20px; /* Espacement */
	text-align: center;
}

header .account-info {
	background-color: rgba(255, 255, 255, 0.2); /* Fond semi-transparent */
	border-radius: 5px; /* Coins arrondis */
	padding: 15px;
	margin-bottom: 20px;
}

header .account-info h2 {
	font-size: 24px;
	margin: 0;
}

header .account-info p {
	font-size: 18px;
	margin: 5px 0;
}

.container {
	text-align: center;
	margin-top: 50px;
	color: white;
	/* Texte en blanc pour bien contraster avec l'image de fond */
}

.notification {
	background-color: rgba(76, 175, 80, 0.8);
	/* Fond vert légèrement transparent */
	color: white;
	padding: 15px;
	margin-bottom: 20px;
	border-radius: 5px;
	font-size: 18px;
}

.menu {
	margin-top: 20px;
}

.menu a {
	text-decoration: none;
	color: #333;
	padding: 10px 15px;
	border: 1px solid #ddd;
	margin: 5px;
	border-radius: 5px;
	background-color: #fff;
	transition: background-color 0.3s;
}

.menu a:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<header class="header">
		<div class="account-info">
			<h2>
				Bienvenue,
				<%= compte != null ? compte.getName() : "Invité" %></h2>
			<p>
				ID:
				<%= compte != null ? compte.getId() : "Non défini" %></p>
			<p>
				Solde actuel :
				<%= request.getAttribute("compte") != null ? compte.getSolde(): "0" %>
				DT
			</p>
		</div>
	</header>

	<div class="container">
		<div class="notification">Vous êtes maintenant enregistré avec
			succès !</div>
		<div class="menu">
			<h3>Naviguer avec liberté</h3>
			<a href="listFilms.jee"> Liste des Films </a> <a
				href="addFilm.jee?id=<%=compte.getId()%>""> Ajouter Un film</a> <a
				href="Reserver.jee?id=<%=compte.getId()%>">Reserver</a> <!--//nemshou
			ebl reserver ll servlet de reservation :1-nedou el userbean besh
			njibou el user , 2- njbou el user (comme quoi nvirifou : bel init :
			idha ken fammech moshkl nhezzouh lpage jsp fiha les salles (njibou
			les salles wna3touh el jsp ) ba3ed jsp salles fiha dor lkol salle
			m3aha 9ars ll seance mte3ha )-->
		</div>
	</div>
</body>
</html>
