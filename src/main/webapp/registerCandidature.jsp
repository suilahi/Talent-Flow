<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire de postuler </title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex items-center justify-center min-h-screen bg-gray-100">
    <div class="w-full max-w-md bg-white p-6 rounded-lg shadow-md">
        <h2 class="text-xl font-semibold text-center mb-4">Soumettre votre CV</h2>
        <form action="CandidateServlet" method="POST" enctype="multipart/form-data" class="space-y-4">

            <div>
                <label class="block text-gray-700">Téléphone</label>
                <input type="tel" name="phone" class="w-full p-2 border rounded-md focus:ring focus:ring-blue-300" required>
            </div>
            <div>
                <label class="block text-gray-700">CV (PDF)</label>
                <input type="text" name="cv"  class="w-full p-2 border rounded-md focus:ring focus:ring-blue-300" required>
            </div>
            <button type="submit" class="w-full bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600">Envoyer</button>
        </form>
    </div>
</body>
</html>