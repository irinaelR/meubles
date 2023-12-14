<%-- 
    Document   : index3.jsp
    Created on : 12 déc. 2023, 15:39:39
    Author     : Finaritra
--%>

<%@page import="Model.Matiere"%>
<%@page import="java.util.List"%>
<%@page import="Model.Style"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Style> listeStyle = (List<Style>)request.getAttribute("listeStyle"); 
List<Matiere> listeMateriel = (List<Matiere>)request.getAttribute("listeMateriel"); 
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
            <form action="TraitementAjoutMateriel" method="get" class="form-card">
                <h3>Ajout Materiel par Style</h3>
                <div class="input-wrapper">
                <label for="Style">Style</label>
                    <select name="idStyle" id="style">
                        <% for(int i=0 ; i< listeStyle.size() ; i++){ %>
                            <option value="<%= listeStyle.get(i).getIdStyle() %>"><%= listeStyle.get(i).getNomStyle() %></option>
                       <% } %>
                </select>    
                </div>
                
                <div class="input-wrapper">
                    <label for="Meteriel">Materiel</label>
                    <select name="idMateriel" id="materiel">
                       <% for(int i=0 ; i< listeMateriel.size() ; i++){ %>
                            <option value="<%= listeMateriel.get(i).getIdMatiere() %>"><%= listeMateriel.get(i).getNomMatiere() %></option>
                       <% } %>
                    </select>
                </div>
                
                <input type="submit" value="OK" class="btn btn-brown">
            </form>
        </div>
    
    </body>
</html>
