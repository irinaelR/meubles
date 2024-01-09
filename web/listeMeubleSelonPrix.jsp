<%-- 
    Document   : insertionGlobal
    Created on : 12 déc. 2023, 22:21:23
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Produit> produits = request.getAttribut("listeProduit");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<<<<<<< Updated upstream
=======

        <div id="main-container">
           
                <h3>Liste meuble selon prix</h3>
                <div class="input-wrapper">
                    
                    <table>
                        <tr>
                            <td>Nom meuble</td>
                            <td>Prix</td>
                        </tr>
                        
                        <%
                            for(Produit produit : produits ) { %>
                               <tr>
                                    <td><%= produit.getNomCategorie() %> <%= produit.getNomStyle() %>  <%= produit.getNomVolume() %> </td>
                                    <td><%= produit.getPrix() %></td>
                                 
                                </tr> 
                            <% }
                           
                        %>
                        
                        
                    </table>
                    
                </div>
            <br>
            <br>
            
        <br>
        <br>
    </body>
</html>
