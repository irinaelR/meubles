<%-- 
    Document   : listeMatiereFabrication
    Created on : Dec 19, 2023, 3:02:15 PM
    Author     : Irina
--%>

<%@page import="java.util.List"%>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    List<Matiere> listeMatiere = new Matiere().select(null);
    int idTcs= (int)request.getAttribute("idTcs");
    out.println(idTcs);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/style1.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main-container">
            <form action="TraitementInsertionFabrication" method="get" class="form-card">
                <h3>Liste matiere pour la fabrication</h3>
                
                <input type="hidden" name="idTcs" value="<%= idTcs %>">
                <% for(int i=0 ;i <listeMatiere.size() ;i++){ %>
                    <div class="input-wrapper">
                        <input type="checkbox" name="idMatiere[]" value="<%= listeMatiere.get(i).getIdMatiere()  %>">
                        <label><%= listeMatiere.get(i).getNomMatiere()  %></label>
                        <input type="number" name="quantite[]" placeholder="Quantite...">
                    </div>
                <% } %>
<!--                <div class="input-wrapper">
                    <input type="checkbox" name="idMatiere[]" value="#">
                    <label>Matiere 2</label>
                    <input type="number" name="quantite[]" placeholder="Quantite...">
                </div>
                <div class="input-wrapper">
                    <input type="checkbox" name="idMatiere[]" value="#">
                    <label>Matiere 3</label>
                    <input type="number" name="quantite[]" placeholder="Quantite...">
                </div>-->
                <input type="submit" class="btn btn-brown" value="OK">
            </form>
        </div>
    </body>
</html>
