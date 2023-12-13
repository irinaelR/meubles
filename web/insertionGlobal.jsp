<%-- 
    Document   : insertionGlobal
    Created on : 12 déc. 2023, 22:21:23
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="TraitementInsertionCategorie" method="get">
            <h3>Insertion Categorie</h3>
            <label for="Nom">Categorie</label>
            <input type="text" name="nom" id="nom">
            <input type="submit" value="OK">
        </form>
        <br>
        <br>
        
       
        <form action="TraitementInsertionMateriel" method="get">
             <h3>Insertion Materiel</h3>
             <label for="Nom">Nom</label> 
             <input type="text" name="nom" id="nom">
             <input type="submit" value="OK">
        </form>
        <br>
        <br>
        
        <form action="TraitementInsertStyle" method="get">
            <h3>Insertion Style</h3>
            <label for="Nom">Nom</label>
            <input type="text" name="nom" id="nom">
            <input type="submit" value="OK">
        </form>
        <br>
        <br>
    </body>
</html>
