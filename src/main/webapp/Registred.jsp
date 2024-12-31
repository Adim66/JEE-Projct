<%@ page import="CinemaJEE.com.cinema.entities.Compte"  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%   Compte compte= ( Compte)  request.getAttribute("compte");  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enregistrement Réussi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://prod.cdn-medias.jeuneafrique.com/cdn-cgi/image/q=auto,f=auto,metadata=none,width=1800,fit=cover/https://prod.cdn-medias.jeuneafrique.com/medias/2018/12/21/3078493320_aa0a7ec1bd_b.jpg'); 
            background-size: cover; /* L'image couvre toute la page */
            background-position: center; /* Centre l'image */
            background-attachment: fixed; /* L'image reste fixe lors du défilement */
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
            margin-top: 50px;
            color: white; /* Texte en blanc pour bien contraster avec l'image de fond */
        }
        .notification {
            background-color: rgba(76, 175, 80, 0.8); /* Fond vert légèrement transparent */
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
    <div class="container">
        <div class="notification">
            Vous êtes maintenant enregistré avec succès !
        </div>
        <div class="menu">
            <h3>Menu des films</h3>
            <a href="listFilms.jee">Liste des Films</a> 
            <a href="addFilm.jee"> Ajouter Un film</a> //jsp pour lister les films , 
            <a href="Reserver.jee?id=<%=compte.getId()%>">Reserver</a> //nemshou ebl reserver ll servlet de reservation :1-nedou el userbean besh njibou el user , 2- njbou el user (comme quoi nvirifou : bel init : idha ken fammech moshkl nhezzouh lpage jsp fiha les salles (njibou les salles  wna3touh el jsp ) ba3ed jsp salles fiha dor lkol salle m3aha 9ars ll seance mte3ha  )  
        </div>
    </div>
</body>
</html>
