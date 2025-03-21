<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bibliothèque - Accueil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container text-center mt-5">
    <h1 class="mb-4">Gestion de Bibliothèque</h1>
    <div class="row">
        <div class="col-md-4">
            <a href="users.jsp" class="btn btn-primary btn-lg w-100">Gérer les Utilisateurs</a>
        </div>
        <div class="col-md-4">
            <a href="documents.jsp" class="btn btn-success btn-lg w-100">Gérer les Documents</a>
        </div>
        <div class="col-md-4">
            <a href="borrow.jsp" class="btn btn-warning btn-lg w-100">Gérer les Emprunts</a>
        </div>
    </div>
</div>

</body>
</html>
