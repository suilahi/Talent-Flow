<%@ page import="java.util.List" %>
<%@ page import="OffreEmploi.Model.OffreEmploi" %>
<%@ page import="authentification.Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    HttpSession sessionObj = request.getSession(false);
    User user = (sessionObj != null) ? (User) sessionObj.getAttribute("user") : null;
    if (user == null || !"recruiter".equals(user.getRole())) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Offres d'Emploi - TalentFlow</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body { font-family: 'Poppins', sans-serif; background-color: #FAFAFA; color: #607D8B; min-height: 100vh; margin: 0; display: flex; flex-direction: column; }
        .navbar { background-color: #607D8B; padding: 1rem; box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); }
        .navbar-brand { font-weight: 600; font-size: 1.8rem; color: #FAFAFA !important; transition: transform 0.3s; }
        .navbar-brand:hover { transform: scale(1.05); }
        .nav-link { color: #FAFAFA !important; font-weight: 400; margin: 0 10px; padding: 8px 15px; border-radius: 20px; transition: background-color 0.3s, color 0.3s; }
        .nav-link:hover { background-color: #90CAF9; color: #FFFFFF !important; }
        .offers-section { padding: 60px 0; background: linear-gradient(to right, #FAFAFA, #B2DFDB); flex-grow: 1; }
        .table { background: #B2DFDB; border-radius: 15px; box-shadow: 0 6px 20px rgba(0, 0, 0, 0.05); }
        .table th { background-color: #607D8B; color: #FAFAFA; }
        .table td a { color: #90CAF9; margin-right: 10px; text-decoration: none; }
        .table td a:hover { color: #42A5F5; }
        .btn-create { background-color: #90CAF9; border: none; border-radius: 20px; padding: 10px 20px; color: white; transition: background-color 0.3s, transform 0.3s; }
        .btn-create:hover { background-color: #42A5F5; transform: scale(1.05); color: white; }
        footer { background-color: #00695C; color: #FAFAFA; padding: 25px 0; text-align: center; }
        @media (max-width: 768px) { .navbar-nav { text-align: center; } .nav-link { margin: 5px 0; } .table { font-size: 0.9rem; } }
    </style>
</head>
<body>
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
                <li class="nav-item"><a class="nav-link" href="jobOffers?action=list">Mes Offres</a></li>
                <li class="nav-item"><a class="nav-link" href="Offrelist.jsp">Toutes les Offres</a></li>
                <li class="nav-item"><a class="nav-link" href="logout">Déconnexion</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="offers-section">
    <div class="container">
        <h1 class="text-center mb-5" style="font-weight: 600;">Gestion des Offres d'Emploi</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Titre</th>
                <th>Description</th>
                <th>Recruteur ID</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="offre" items="${offreEmploi}">
                <tr>
                    <td>${offre.id}</td>
                    <td>${offre.title}</td>
                    <td>${offre.description}</td>
                    <td>${offre.recruiter}</td>
                    <td>
                        <a href="jobOffers?action=edit&id=${offre.id}">Modifier</a>
                        <a href="jobOffers?action=delete&id=${offre.id}" onclick="return confirm('Voulez-vous vraiment supprimer cette offre ?');">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty offreEmploi}">
                <tr><td colspan="5" class="text-center">Aucune offre disponible.</td></tr>
            </c:if>
            </tbody>
        </table>
        <div class="text-center mt-4">
            <a href="jobOfferForm.jsp" class="btn btn-create">Ajouter une Offre</a>
        </div>
    </div>
</section>

<footer>
    <div class="container">
        <p>© 2025 TalentFlow. Tous droits réservés.</p>
        <p>Contactez-nous : support@talentflow.com | +33 (0)1 23 45 67 89</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>