<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="Model.Produit" %>
<%@page import="java.util.List"%>

<% 
    Produit prod = new Produit();
    List<Produit> produits = prod.selectProduit(null);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <title>Fabrication Produit</title>
</head>
<body>
    <form action="TraitementFabricationProduit" method="get">
        <select name="produit" id="produit">
            <%
                for(Produit produit : produits) { %>
                    <option value=<%= produit.getIdtcs() %>><%= produit.getNomCategorie() %> <%= produit.getNomStyle() %> <%= produit.getNomVolume() %></option>
                <%}
            %>
        </select>
        <input type="number" name="quantite" id="quantite">
        <input type="submit" value="OK">
    </form>
</body>
</html>