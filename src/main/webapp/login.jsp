<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - TalentFlow</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(to right, #90CAF9, #B2DFDB);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login-container {
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
            animation: fadeIn 1s ease-in-out;
        }
        .login-container h2 {
            margin-bottom: 20px;
            font-weight: 600;
            color: #607D8B;
        }
        .form-control {
            border-radius: 10px;
        }
        .btn-login {
            background-color: #42A5F5;
            border: none;
            border-radius: 10px;
            padding: 10px;
            color: white;
            width: 100%;
            transition: 0.3s;
        }
        .btn-login:hover {
            background-color: #1E88E5;
            transform: scale(1.05);
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Connexion</h2>
    <form action="login" method="post">
        <div class="mb-3">
            <input type="email" name="email" class="form-control" placeholder="Email" required>
        </div>
        <div class="mb-3">
            <input type="password" name="password" class="form-control" placeholder="Mot de passe" required>
        </div>
        <button type="submit" class="btn btn-login">Se Connecter</button>
    </form>
    <p class="mt-3">Pas encore inscrit ? <a href="register.jsp">Créer un compte</a></p>
</div>
</body>
</html>