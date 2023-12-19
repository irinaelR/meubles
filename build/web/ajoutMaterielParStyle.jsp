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
        <title>JSP Page</title>
    </head>
    <body>
    <form action="TraitementAjoutMateriel" method="get">
        <h3>Ajout Materiel par Style</h3>
        <label for="Style">Style</label>
        <select name="idStyle" id="style">
            <% for(int i=0 ; i< listeStyle.size() ; i++){ %>
                <option value="<%= listeStyle.get(i).getIdStyle() %>"><%= listeStyle.get(i).getNomStyle() %></option>
           <% } %>
        </select>
        <label for="Meteriel">Materiel</label>
        <select name="idMateriel" id="materiel">
           <% for(int i=0 ; i< listeMateriel.size() ; i++){ %>
                <option value="<%= listeMateriel.get(i).getIdMatiere() %>"><%= listeMateriel.get(i).getNomMatiere() %></option>
           <% } %>
        </select>
        <input type="submit" value="OK">
    </form>
    </body>
</html>
