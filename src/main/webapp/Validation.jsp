<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  String id=  (String) request.getAttribute("id") ; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation de Validation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .navbar {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            font-size: 18px;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        .container {
            text-align: center;
            margin: 100px auto;
            max-width: 600px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }

        .success-message {
            font-size: 24px;
            color: green;
            margin-bottom: 20px;
            animation: fadeIn 2s;
        }

        .button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #0056b3;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: scale(0.9);
            }
            to {
                opacity: 1;
                transform: scale(1);
            }
        }
    </style>
    <script>
        function showAlert() {
            alert("Votre action a été validée avec succès !");
        }

        window.onload = function() {
            showAlert();
        };
    </script>
</head>
<body>
    <div class="navbar">
        <span>Application</span>
        <a href="Registred.jee?id=<%=id %>">Retour au Menu</a>
    </div>

    <div class="container">
        <div class="success-message">Votre action a été validée avec succès !</div>
        <a href="Home.jee">
            <button class="button">Quitter vers Espace Visiteur </button>
        </a>
    </div>
</body>
</html>
