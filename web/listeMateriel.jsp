<%-- 
    Document   : index5
    Created on : 12 déc. 2023, 15:58:47
    Author     : Finaritra
--%>

<%@page import="Model.Matiere"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Matiere> listeMatiere= (List<Matiere>)request.getAttribute("listeMatiere"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h3>Liste des Materiels</h3>
    <ul>
        <% for(int i=0 ; i<listeMatiere.size() ; i++){ %>
        <li><%= listeMatiere.get(i).getNomMatiere() %></li>
        <% } %>
       
       
    </ul>
    </body>
</html>
