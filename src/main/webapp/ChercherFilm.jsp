<%@ page import="CinemaJEE.com.cinema.model.NavigationSallesProModel,CinemaJEE.com.cinema.entities.Film,java.util.Set" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Recherche de Films</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
        }

        /* Styles pour le menu à gauche */
        .menu {
            width: 20%;
            background-color: #f4f4f4;
            padding: 15px;
            border-right: 1px solid #ddd;
        }

        .menu a {
            display: block;
            color: #333;
            text-decoration: none;
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
        }

        .menu a:hover {
            background-color: #ddd;
        }

        /* Styles pour le contenu principal */
        .content {
            width: 80%;
            padding: 20px;
        }

        .search-bar {
            margin-bottom: 20px;
        }

        .search-bar input[type="text"] {
            width: 70%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .search-bar button {
            padding: 10px 15px;
            font-size: 16px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .search-bar button:hover {
            background-color: #4cae4c;
        }

        /* Styles pour les cartes de films */
        .movie-list {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            margin-top: 20px;
        }

        .card {
            width: 200px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            text-align: center;
            background-color: #fff;
        }

        .card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
        }

        .card h3 {
            margin: 10px 0;
            font-size: 1.2rem;
            color: #333;
        }

        .card p {
            font-size: 0.9rem;
            color: #555;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <!-- Menu à gauche -->
    <div class="menu">
        <h3>Menu</h3>
        <a href="index.jsp">Accueil</a>
        <a href="movies.jsp">Films</a>
        <a href="programmes.jsp">Programmes</a>
        <a href="contact.jsp">Contact</a>
    </div>

    <!-- Contenu principal -->
    <div class="content">
        <h2>Recherche de Films</h2>

        <!-- Barre de recherche -->
        <div class="search-bar">
            <form action="listFilms.jee" method="GET">
                <input type="text" name="query" placeholder="Entrez le nom du film..." required>
                <button type="submit">Rechercher</button>
            </form>
        </div>

        <!-- Liste des résultats -->
        <div class="movie-list">
            <%
                // Récupérer le paramètre de recherche
                Set<Film> films = (Set<Film>) request.getAttribute("films");
                if (films == null || films.isEmpty()) {
            %>
                <p>Aucun film trouvé.</p>
            <%
                } else {
                    for (Film film : films) {
            %>
                <div class="card">
                    <img src="https://st4.depositphotos.com/1105977/21051/i/450/depositphotos_210519084-stock-photo-vintage-film-claper-film-reel.jpg" alt="Film Image">
                    <h3><%= film.getName() %></h3>
                  
                </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</body>
</html>
