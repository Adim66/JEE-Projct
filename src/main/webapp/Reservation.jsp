<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, CinemaJEE.com.cinema.entities.Seance" %>
<%
    // On récupère la liste des séances depuis l'attribut de la requête
    List<Seance> seances = (List<Seance>) request.getAttribute("seances");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Séances</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
            font-family: Arial, sans-serif;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f4f4f4;
            font-weight: bold;
        }
        .reservation-btn {
            padding: 8px 12px;
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }
        .reservation-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">Liste des Séances</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Horaire</th>
                <th>Places</th>
                <th>Tarif</th>
                <th>Salle ID</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% if (seances != null && !seances.isEmpty()) { %>
                <% for (Seance seance : seances) { %>
                    <tr>
                        <td><%= seance.getId() %></td>
                        <td><%= seance.getHoraire() %></td>
                        <td><%= seance.getPlaces() %></td>
                        <td><%= seance.getTarif() %></td>
                        <td><%= seance.getSalle().getSalle_mere().getAdress() %></td>
                        <td>
                            <form action="pageX.jsp" method="GET">
                                <input type="hidden" name="seanceId" value="<%= seance.getId() %>">
                                <button type="submit" class="reservation-btn">RESERVATION</button>
                            </form>
                        </td>
                    </tr>
                <% } %>
            <% } else { %>
                <tr>
                    <td colspan="6">Aucune séance disponible.</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
