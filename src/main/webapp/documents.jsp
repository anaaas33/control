<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestion des Documents</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">Liste des Documents</h2>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="documentController" class="com.example.librarymanagement.controller.DocumentController" />
        <%
            for (com.example.librarymanagement.model.Document doc : documentController.getAllDocuments()) {
        %>
        <tr>
            <td><%= doc.getId() %></td>
            <td><%= doc.getTitle() %></td>
            <td><%= doc.getClass().getSimpleName() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <a href="index.jsp" class="btn btn-secondary mt-3">Retour à l'accueil</a>
</div>

</body>
</html>
