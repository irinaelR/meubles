<%-- 
    Document   : statistique
    Created on : 30 janv. 2024, 00:45:10
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Client,Model.Produit,java.util.List,java.sql.Connection,connexion.*" %>
<% 
    Produit produit = new Produit();
    List<Produit> produits = produit.selectProduit(null);
    int[] resultatStat= (int[])request.getAttribute("resultatStat");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Statistique</h1>
        <form action="TraitementStatParGenre" method="get">
              <select name="produit" id="">
                  <option value="0">tout</option>
                <%
                    for(int i=0;i<produits.size();i++) { %>
                        <option value="<%= produits.get(i).getIdtcs() %>"><%= produits.get(i).getNomStyle() %> <%= produits.get(i).getNomCategorie() %> <%= produits.get(i).getNomVolume() %></option>
                    <% }
                %>
            </select>
            <input type="submit" value="ok">
        </form>
            
            <% if(resultatStat!=null){ %>
            <table>
                <tr>
                    <th>Homme </th>
                    <th>Femme</th>
                </tr>
                <tr>
                    <td> <%= resultatStat[0] %></td>
                    <td> <%= resultatStat[1] %></td>
                </tr>
            </table>
            <% } %>
    </body>
</html>
