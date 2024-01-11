<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="Model.Matiere" %>
<%@page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <title>Achat Matiere Premiere</title>
</head>
<body>
    <form action="TraitementAchatMatierePremiere" method="get">
        <select name="achatmatierepremiere" id="">
            <%
            
                List<Matiere> matieres = new Matiere().select(null);
                for(Matiere m : matieres) {
                    out.println("<option value='" + m.getIdMatiere() + "'>" + m.getNomMatiere() + "</option>");
                }
               
            %>
            
        </select>
        <input type="number" name="quantite" id="quantite" placeholder="Quantite">
        <input type="submit" value="OK">
    </form>
</body>
</html>