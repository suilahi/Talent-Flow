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
            min-height: 100vh;
            margin: 0;
            display: flex;
            flex-direction: column;
        }
        .navbar {
            background-color: #607D8B;
            padding: 1rem;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand {
            font-weight: 600;
            font-size: 1.8rem;
            color: #FAFAFA !important;
            transition: transform 0.3s;
        }
        .navbar-brand:hover {
            transform: scale(1.05);
        }
        .nav-link {
            color: #FAFAFA !important;
            font-weight: 400;
            margin: 0 10px;
            padding: 8px 15px;
            border-radius: 20px;
            transition: background-color 0.3s, color 0.3s;
        }
        .nav-link:hover {
            background-color: #90CAF9;
            color: #FFFFFF !important;
        }
        .login-container {
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
            animation: fadeIn 1s ease-in-out;
            margin: auto;
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
            background-color: #90CAF9;
            border: none;
            border-radius: 20px;
            padding: 10px;
            color: white;
            width: 100%;
            transition: background-color 0.3s, transform 0.3s;
        }
        .btn-login:hover {
            background-color: #42A5F5;
            transform: scale(1.05);
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        footer {
            background-color: #00695C;
            color: #FAFAFA;
            padding: 25px 0;
            text-align: center;
            margin-top: auto;
        }
        @media (max-width: 768px) {
            .navbar-nav { text-align: center; }
            .nav-link { margin: 5px 0; }
        }
    </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">TalentFlow</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Basculer la navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Accueil</a></li>
                <li class="nav-item"><a class="nav-link" href="offerEmploi.jsp">Offres d'Emploi</a></li>
                <li class="nav-item"><a class="nav-link" href="Offrelist.jsp">Liste des Offres</a></li>
                <li class="nav-item"><a class="nav-link" href="candidat.jsp">Espace Candidat</a></li>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Connexion</a></li>
                <li class="nav-item"><a class="nav-link" href="register.jsp">Inscription</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Login Form -->
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

<!-- Footer -->
<footer>
    <div class="container">
        <p>© 2025 TalentFlow. Tous droits réservés.</p>
        <p>Contactez-nous : support@talentflow.com | +33 (0)1 23 45 67 89</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>