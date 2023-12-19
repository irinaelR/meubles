<%-- 
    Document   : insertMeuble
    Created on : Dec 19, 2023, 2:49:27 PM
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--

    Document statique
    Formulaire sans action/redirection

-->
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
                    <label>Petit</label>
                    <input type="checkbox" name="petit" class="champs" value="#">
                </div>
                <div class="input-wrapper">
                    <label>Grand</label>
                    <input type="checkbox" name="grand" class="champs" value="#">
                </div>
                <input type="submit" class="btn btn-brown" value="OK">
            </form>
        </div>
    </body>
</html>
