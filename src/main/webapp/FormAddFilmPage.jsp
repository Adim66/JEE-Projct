<%@ page import="CinemaJEE.com.cinema.entities.Salle,java.util.List" contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Associer Film à des Salles</title>
    <style>
        /* Style de base */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            color: #333;
        }

        h2 {
            text-align: center;
            color: #444;
        }

        form {
            width: 60%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            margin: 10px 0 5px;
            display: inline-block;
            color: #555;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        input[type="checkbox"] {
            margin-right: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            display: block;
            width: 100%;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .checkbox-container {
            margin-bottom: 15px;
        }

        .checkbox-container input {
            margin-top: 10px;
        }

        .checkbox-container label {
            display: inline-block;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h2>Associer un Film à des Salles</h2>

    <form action="filmconfirmedadd.jee" method="post">
        <!-- Champ pour le nom du film -->
        <label for="filmName">Nom du Film:</label>
        <input type="text" id="filmName" name="filmName" required/><br/><br/>

        <!-- Liste des salles avec cases à cocher -->
        <label>Salles :</label><br/>
        <% 
            // Affichage des salles avec cases à cocher dans le formulaire
            List<Salle> salles = (List<Salle>) request.getAttribute("salles");
            for (Salle salle : salles) {
        %>
            <div class="checkbox-container">
                <input type="checkbox" name="salles" value="<%= salle.getId() %>"/> <%= salle.getName() %>
            </div>
        <% } %>
        <br/>

        <!-- Bouton de soumission -->
        <input type="submit" value="Associer Film"/>
    </form>
</body>
</html>
