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
        <link rel="stylesheet" href="assets/css/style1.css">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="main-container">
            <form action="TraitementInsertionCategorie" method="get" class="form-card">
                <h3>Insertion Categorie</h3>
                <div class="input-wrapper">
                    <label>Categorie</label>
                    <input type="text" class="champs" name="nom">
                    <input type="submit" class="btn btn-brown" value="OK">
                </div>
            </form>
            <br>
            <br>
            
           
            <form action="TraitementInsertionMateriel" method="get" class="form-card">
                 <h3>Insertion Materiel</h3>
                 <div class="input-wrapper">
                    <label>Nom</label> 
                    <input type="text" class="champs" name="nom">
                    <input type="submit" class="btn btn-brown" value="OK">
                 </div>
            </form>
            <br>
            <br>
            
            <form action="TraitementInsertStyle" method="get" class="form-card">
                <h3>Insertion Style</h3>
                <div class="input-wrapper">
                    <label>Nom</label>
                    <input type="text" class="champs" name="nom">
                    <input type="submit" class="btn btn-brown" value="OK">
                </div>
            </form>
        </div>
        
        
        <br>
        <br>
    </body>
</html>
