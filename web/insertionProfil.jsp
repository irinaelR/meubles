<%-- 
    Document   : insertionProfil
    Created on : 23 janv. 2024, 15:21:24
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion Profil</title>
    </head>
    <body>
        <h1>Profil</h1>
        <form action='InsertionProfil' method='get'>
            <div>
                <label>Nom</label>
                <input name='nom' type='text' required>
            </div>
            <div>
                <label>Experience Minimum</label>
                <input name='experienceMin' type='number' required>
                <label>Experience Maximum</label>
                <input name='experienceMax' type='number' required>
            </div>
            <div>
                <label>Niveau</label>
                <input name='niveau' type='text' required>
            </div>
            <input value='OK' type='submit'>
        </form>
    </body>
</html>
