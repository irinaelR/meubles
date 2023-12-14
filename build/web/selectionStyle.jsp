<%-- 
    Document   : index1.jsp
    Created on : 12 déc. 2023, 15:24:38
    Author     : Finaritra
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Style"%>
<%@page import="connexion.Connexion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<Style> listeStyle= new Style().select(Connexion.Connect()); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/style1.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div id="main-container">
            <form action="VoirMatiereParStyle" method="get" class="form-card">
                <h3>Style</h3>
                <div class="input-wrapper">
                    <select name="style" id="style" class="champs">
                        <% for(int i=0 ; i< listeStyle.size() ; i++){ %>
                            <option value="<%= listeStyle.get(i).getIdStyle() %>"><%= listeStyle.get(i).getNomStyle() %></option>
                        <% } %>
                    </select>     
                    <input type="submit" value="OK" class="btn btn-brown">
                </div>
                
            </form>

        </div>
    
    </body>
</html>
