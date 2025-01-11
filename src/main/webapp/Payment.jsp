<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="CinemaJEE.com.cinema.entities.Compte,CinemaJEE.com.cinema.entities.Seance"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calcul du Tarif</title>
    <style>
        /* Style général de la page */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        h2 {
            color: #333;
            margin-top: 20px;
        }

        /* Conteneur principal pour l'affichage des informations */
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin-top: 20px;
        }

        /* Mise en forme des informations */
        p {
            font-size: 16px;
            line-height: 1.6;
            margin: 10px 0;
        }

        .green-text {
            color: green;
            font-weight: bold;
        }

        .red-text {
            color: red;
            font-weight: bold;
        }

        /* Formulaire et boutons */
        form {
            margin-top: 20px;
        }

        input[type="hidden"] {
            display: none;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Style de la barre de navigation */
        .navbar {
            background-color: #333;
            overflow: hidden;
        }

        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Responsivité */
        @media (max-width: 768px) {
            .container {
                width: 95%;
            }

            h2 {
                font-size: 24px;
            }
        }
    </style>
</head>
<body>

    <!-- Barre de navigation -->
    <div class="navbar">
        <a href="index.jsp">Retour au menu</a>
    </div>

    <div class="container">
        <h2>Calcul du Tarif pour une Séance</h2>

        <%
            // Récupération des objets passés depuis le contrôleur
            Compte compte = (Compte) request.getAttribute("compte");
            Seance seance = (Seance) request.getAttribute("seance");

            if (compte != null && seance != null) {
                double solde = compte.getSolde();
                double tarif = seance.getTarif();

                // Affichage des informations du compte et de la séance
                out.println("<p>Compte : " + compte.getName() + " (ID : " + compte.getId() + ")</p>");
                out.println("<p>Solde actuel : " + compte.getSolde() + " DT</p>");
                out.println("<p>Séance : " + seance.getTarif() + " (Tarif : " + tarif + " DT)</p>");

                if (solde >= tarif) {
                    // Solde suffisant
                    out.println("<p class='green-text'>Vous pouvez réserver cette séance.</p>");
                    out.println("<form method='post' action='Validation.jee'>");
                    out.println("<input type='hidden' name='compteId' value='" + compte.getId() + "'>");
                    out.println("<input type='hidden' name='seanceId' value='" + seance.getId() + "'>");
                    out.println("<button type='submit'>Confirmer la réservation</button>");
                    out.println("</form>");
                } else {
                    // Solde insuffisant
                    double difference = tarif - solde;
                    out.println("<p class='red-text'>Solde insuffisant. Il vous manque " + difference + " DT.</p>");
                }
            } else {
                out.println("<p class='red-text'>Les informations du compte ou de la séance sont introuvables.</p>");
            }
        %>
    </div>

</body>
</html>
