<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<%@page import="Model.Client,Model.Produit,java.util.List,java.sql.Connection,connexion.*" %>

<%
    Client client = new Client();
    Produit produit = new Produit();
    Connection con = new Connexion().Connect();
    List<Client> clients = client.select(con);
    List<Produit> produits = produit.selectProduit(con);

%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>Vente</h2>
        <form action="InsertionVenteServlet" method="get">
            <select name="client" id="">
                <%
                    for(int i=0;i<clients.size();i++) { %>
                        <option value="<%= clients.get(i).getIdClient() %>"><%= clients.get(i).getNom() %></option>
                    <% }
                %>
            </select>

            <select name="produit" id="">
                <%
                    for(int i=0;i<produits.size();i++) { %>
                        <option value="<%= produits.get(i).getIdtcs() %>"><%= produits.get(i).getNomStyle() %> <%= produits.get(i).getNomCategorie() %> <%= produits.get(i).getNomVolume() %></option>
                    <% }
                %>
            </select>

            <input type="date" name="date">
            <input type="number" name="quantite">

            <input type="submit" value="Valider">
        </form>
    </body>
</html>
