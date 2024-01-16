<%-- 
    Document   : insertionHeureParStyle
    Created on : Jan 16, 2024, 3:18:27 PM
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion nombre d'heures par style</title>
    </head>
    <body>
        <h1>Insertion nombre d'heures par style</h1>
        <form method="get" action="">
            <label>Style</label>
            <select name="style">
                <option value="">Boheme</option>
            </select>
            <br/>
            <input type="number" name="nbHeure" placeholder="Nombre d'heures">
            <input type="submit" value="OK">
        </form>
    </body>
</html>
