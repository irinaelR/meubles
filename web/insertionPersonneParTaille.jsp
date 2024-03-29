<%-- 
    Document   : insertionPersonneParTaille
    Created on : Jan 16, 2024, 3:16:01 PM
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Volume" %>
<%@page import="java.util.List" %>


<%
    Volume volume = new Volume();
    List<Volume> volumes = volume.select(null);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion du nombre de personnes par taille</title>
    </head>
    <body>
        <h1>Insertion du nombre de personnes par taille</h1>
        <form method="get" action="">
            <label>Taille</label>
            <select name="taille">
                <%
                    for(int i=0; i<styles.size(); i++) { %>
                        <option value=<%= styles.get(i).getIdStyle() %>><%= styles.get(i).getNomStyle() %></option>
                    <% }
                %>
            </select>
            <br>
            <input type="number" name="nbPersonne" placeholder="Nombre de personnes">
            <input type="submit" value="OK">
        </form>
    </body>
</html>
