<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un Compte - TalentFlow</title>
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
        .register-container {
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
            animation: fadeIn 1s ease-in-out;
        }
        .register-container h2 {
            margin-bottom: 20px;
            font-weight: 600;
            color: #607D8B;
        }
        .form-control {
            border-radius: 10px;
        }
        .btn-register {
            background-color: #42A5F5;
            border: none;
            border-radius: 10px;
            padding: 10px;
            color: white;
            width: 100%;
            transition: 0.3s;
        }
        .btn-register:hover {
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
<div class="register-container">
    <h2>Créer un Compte</h2>
    <form action="Register" method="post">
        <div class="mb-3">
            <input type="text" name="name" class="form-control" placeholder="Nom complet" required>
        </div>
        <div class="mb-3">
            <input type="email" name="email" class="form-control" placeholder="Email" required>
        </div>
        <div class="mb-3">
            <input type="password" name="password" class="form-control" placeholder="Mot de passe" required>
        </div>
        <div class="mb-3">
            <select name="role" class="form-control" required>
                <option value="">Sélectionner un rôle</option>
                <option value="candidate">Candidat</option>
                <option value="recruiter">Recruteur</option>
            </select>
        </div>
        <button type="submit" class="btn btn-register">S'inscrire</button>
    </form>
    <p class="mt-3">Déjà inscrit ? <a href="login.jsp">Se connecter</a></p>
</div>
</body>
</html>