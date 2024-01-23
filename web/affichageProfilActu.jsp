<%-- 
    Document   : affichageProfilActu
    Created on : 23 janv. 2024, 15:26:52
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*" %>
<%@page import="java.util.List" %>

<%
    ProfilActuel profilActuel = new ProfilActuel();
    try {
        List<ProfilActuel> profilActuels = profilActuel.select(null);
    
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profils Actuels</title>
    </head>
    <body>
        <h1>Profils Actuels</h1>
        <table>
            <tr>
                <th>Nom Employe</th>           
                <th>Profil</th>
                <th>Taux horaire</th>
            </tr>
            
            <%
                for(int i=0; i< profilActuels.size(); i++) { %>
                    <tr>
                        <td><%= profilActuels.get(i).getNomEmployer() %></td>
                        <td><%= profilActuels.get(i).getNomProfil() %></td>
                        <td><%= profilActuels.get(i).getTauxHoraire() %></td>
                    </tr>
                <% }
            %>
            
            
        </table>
    </body>
</html>
<% 
    } catch(Exception e) {
        out.print(e);
    }
%>
