<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TalentFlow - Toutes les Offres d'Emploi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #FAFAFA;
            color: #607D8B;
            min-height: 100vh;
            margin: 0;
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
        .navbar-toggler {
            border-color: #FAFAFA;
        }
        .jobs-section {
            padding: 60px 0;
            background: linear-gradient(to right, #FAFAFA, #B2DFDB);
        }
        .job-card {
            background: #B2DFDB;
            border-radius: 15px;
            padding: 20px;
            margin-bottom: 20px;
            color: #607D8B;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.05);
            transition: transform 0.3s, box-shadow 0.3s;
            opacity: 0;
            animation: fadeInUp 0.5s ease-out forwards;
        }
        .job-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
        }
        .job-title {
            font-size: 1.5rem;
            font-weight: 600;
            margin-bottom: 10px;
        }
        .job-description {
            font-size: 1rem;
            margin-bottom: 15px;
        }
        .btn-apply {
            background-color: #90CAF9;
            border: none;
            padding: 10px 25px;
            border-radius: 20px;
            color: #FFFFFF;
            transition: background-color 0.3s, transform 0.3s;
        }
        .btn-apply:hover {
            background-color: #42A5F5;
            transform: translateY(-2px);
            color: #FFFFFF;
        }
        @keyframes fadeInUp {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        footer {
            background-color: #00695C;
            color: #FAFAFA;
            padding: 25px 0;
            margin-top: 60px;
            text-align: center;
        }
        @media (max-width: 768px) {
            .navbar-nav {
                text-align: center;
            }
            .nav-link {
                margin: 5px 0;
            }
            .job-card {
                margin: 10px 0;
            }
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

<!-- Jobs Section -->
<section class="jobs-section">
    <div class="container">
        <h1 class="text-center mb-5" style="font-weight: 600;">Toutes les Offres d'Emploi</h1>
        <div class="row">
            <c:forEach var="job" items="${jobOffers}" varStatus="loop">
                <div class="col-md-6 col-lg-4" style="animation-delay: ${loop.index * 0.1}s;">
                    <div class="job-card">
                        <h2 class="job-title">${job.title}</h2>
                        <p class="job-description">${job.description}</p>
                        <p><strong>Date de publication :</strong> ${job.publicationDate}</p>
                        <form action="postuler" method="post">
                            <input type="hidden" name="jobId" value="${job.id}">
                            <button type="submit" class="btn btn-apply">Postuler</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
            <c:if test="${empty jobOffers}">
                <div class="col-12 text-center">
                    <p>Aucune offre d'emploi disponible pour le moment.</p>
                </div>
            </c:if>
        </div>
    </div>
</section>

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
