<%-- 
    Document   : insertionGlobal
    Created on : 12 déc. 2023, 22:21:23
    Author     : ITU
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Matiere"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Matiere matiere1= new Matiere();
    List<Matiere> matieres = matiere1.select(null);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="main-container">
            <form action="TraitementAjoutPrixMatiere" method="get" class="form-card">
                <h3>Ajout prix par Matiere</h3>
                <div class="input-wrapper">
                    <label>Categorie</label>
                    
                    <select name="matiere">
                        <%
                            for(Matiere matiere : matieres) { %>
                                <option value=<%= matiere.getIdMatiere() %>><%= matiere.getNomMatiere() %></option>
                            <% }
                        %>
                    </select>
                    <input type="text" class="champs" name="prix">
                    <input type="submit" class="btn btn-brown" value="OK">
                    
                </div>
            </form>
            <br>
            <br>
            
        <br>
        <br>
    </body>
</html>
