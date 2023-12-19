<%-- 
    Document   : index1.jsp
    Created on : 12 déc. 2023, 15:24:38
    Author     : Finaritra
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Style"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Style> listeStyle= new Style().select(null); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <label for="Style">Style</label>
        
    <form action="VoirMatiereParStyle" method="get">
        <select name="style" id="style">
            <% for(int i=0 ; i< listeStyle.size() ; i++){ %>
                <option value="<%= listeStyle.get(i).getIdStyle() %>"><%= listeStyle.get(i).getNomStyle() %></option>
            <% } %>
        </select>     
        <input type="submit" value="OK">
    </form>

    </body>
</html>
