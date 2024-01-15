

<%@page import="Model.*"%>
<%@page import="java.util.List"%>
<%@page import="connexion.Connexion"%>
<%@page import="java.sql.*"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   Connexion connexion = new Connexion();
 Connection con= connexion.Connect();
 try { 
        Style style1= new Style();
        List<Categorie> listeCategorie = new Categorie().select(con);
        List<Style> listeStyle = style1.select(con);
        List<Volume> listeVolume = new Volume().select(con);


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
            <form action="RecuperationProduitAFabriquer" method="get" class="form-card">
                <h3>Taille disponible par categorie</h3>
                <div class="input-wrapper">
                    <label>Categorie</label>
                    <select name="categorie" class="champs">
                        <% for(int i=0 ; i< listeCategorie.size() ; i++){%>
                            <option value="<%= listeCategorie.get(i).getIdCategorie() %>"><%= listeCategorie.get(i).getNomCategorie() %></option>
                        <% } %>

                    </select>
                </div>
                <div class="input-wrapper">
                    <label>Style</label>
                    <select name="style" class="champs">
                        <% for(int i=0 ; i< listeStyle.size() ; i++){%>
                            <option value="<%= listeStyle.get(i).getIdStyle() %>"><%= listeStyle.get(i).getNomStyle() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="input-wrapper">
                    <label>Volume</label>
                    <select name="volume" class="champs">
                        <% for(int i=0 ; i< listeVolume.size() ; i++){%>
                            <option value="<%= listeVolume.get(i).getIdVolume() %>"><%= listeVolume.get(i).getNomVolume() %></option>
                        <% } %>
                    </select>
                </div>
                <input type="submit" class="btn btn-brown" value="OK">
            </form>
        </div>
    </body>
</html>
<% } catch(Exception e){ %>
<h3 style="color: red"> <%= e %></h3>
<% }finally{ 
   con.close();
} %>
