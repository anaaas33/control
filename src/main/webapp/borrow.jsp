<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestion des Emprunts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">Liste des Emprunts</h2>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Utilisateur</th>
            <th>Document</th>
            <th>Date Emprunt</th>
            <th>Date Retour</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="borrowController" class="com.example.librarymanagement.controller.BorrowController" />
        <%
            for (com.example.librarymanagement.model.Borrow borrow : borrowController.getAllBorrows()) {
        %>
        <tr>
            <td><%= borrow.getId() %></td>
            <td><%= borrow.getUser().getName() %></td>
            <td><%= borrow.getDocument().getTitle() %></td>
            <td><%= borrow.getDateBorrow() %></td>
            <td><%= borrow.getReturnDate() != null ? borrow.getReturnDate() : "En cours" %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <a href="index.jsp" class="btn btn-secondary mt-3">Retour à l'accueil</a>
</div>

</body>
</html>
