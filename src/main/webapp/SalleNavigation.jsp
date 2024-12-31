<%@ page import="CinemaJEE.com.cinema.model.NavigationSallesProModel,CinemaJEE.com.cinema.entities.SalleProgramme,java.util.Set" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 NavigationSallesProModel  model= ( NavigationSallesProModel)  request.getAttribute("model_salles");
Set<SalleProgramme> salleProgrammes = (Set<SalleProgramme>) model.getSalles_prog();
        %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Salles Programmées</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
        }
        .salle-programmee {
            border: 1px solid #ccc;
            background-color: #ffffff;
            border-radius: 5px;
            margin-bottom: 20px;
            padding: 15px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .salle-programmee h3 {
            margin: 0;
            color: #333;
        }
        .salle-programmee p {
            margin: 5px 0;
            color: #666;
        }
        .btn {
            display: inline-block;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            padding: 10px 15px;
            border-radius: 3px;
            margin-top: 10px;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Liste des Salles Programmées</h1>
        <% 
            // Récupération de la liste des salles programmées depuis la requête
          //  List<SalleProgramme> salleProgrammes = (List<SalleProgramme>) request.getAttribute("salleProgrammes");
            if (salleProgrammes != null && !salleProgrammes.isEmpty()) {
                for (SalleProgramme salleProg : salleProgrammes) {
        %>
        <div class="salle-programmee">
            <h3>Salle Programmée : <%= salleProg.getSalle_mere().getName() %></h3>
            <p>ID : <%= salleProg.getId() %></p>
            <p>Capacité : <%= salleProg.getSalle_mere().getCapacite() %></p>
            <p>Film : <%= salleProg.getFilm().getName() %></p>
            <form action="SeancesSalle.jee" method="GET">
                <input type="hidden" name="salleProgId" value="<%= salleProg.getId() %>">
                <button type="submit" class="btn">Naviguer les séances</button>
            </form>
        </div>
        <% 
                }
            } else {
        %>
        <p>Aucune salle programmée disponible pour le moment.</p>
        <% 
            }
        %>
    </div>
</body>
</html>