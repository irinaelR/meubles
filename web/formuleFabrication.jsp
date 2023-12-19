<%-- 
    Document   : formuleFabrication
    Created on : Dec 19, 2023, 3:00:45 PM
    Author     : Irina
--%>

<!--

    Document statique
    Formulaire sans action/redirection

-->

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
            <form action="#" method="get" class="form-card">
                <h3>Taille disponible par categorie</h3>
                <div class="input-wrapper">
                    <label>Categorie</label>
                    <select name="categorie" class="champs">
                        <option value="">Canape</option>
                        <option value="">Fauteuil</option>
                        <option value="">Chaise</option>

                    </select>
                </div>
                <div class="input-wrapper">
                    <label>Style</label>
                    <select name="style" class="champs">
                        <option value="">Boheme</option>
                        <option value="">Royal</option>
                    </select>
                </div>
                <div class="input-wrapper">
                    <label>Volume</label>
                    <select name="volume" class="champs">
                        <option value="">Petit</option>
                        <option value="">Grand</option>
                    </select>
                </div>
                <input type="submit" class="btn btn-brown" value="OK">
            </form>
        </div>
    </body>
</html>
