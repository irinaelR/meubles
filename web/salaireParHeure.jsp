<%-- 
    Document   : salaireParHeure
    Created on : Jan 16, 2024, 3:13:50 PM
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.TypeEmploye" %>
<%@page import="java.util.List" %>


<%
    TypeEmploye te = new TypeEmploye();
    List<TypeEmploye> typeEmployes = te.select(null);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salaire par heure</title>
    </head>
    <body>
        <h1>Inserer le salaire par heure des employes</h1>
        <form method="get" action="InsertionSalaire">
            <label>Employe</label>
            <select name="employe">
                <%
                    for(int i=0; i<typeEmployes.size(); i++) { %>
                        <option value=<%= typeEmployes.get(i).getIdType() %>><%= typeEmployes.get(i).getNomType() %></option>
                    <% }
                %>
               
            </select>
            <input type="number" name="salaire" placeholder="Salaire">
            <input type="submit" value="OK">
        </form>
    </body>
</html>
