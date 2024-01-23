<%-- 
    Document   : insertionEmp
    Created on : 23 janv. 2024, 15:24:23
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion Employe</title>
    </head>
    <body>
        <h1>Employe</h1>
        <form action='InsertionEmploye' method='get'>
            <div>
                <label>Nom Employe</label>
                <input name='nomEmploye' type='text' required>
            </div>
            <div>
                <label>Date d'embauche</label>
                <input name='dateEmbauche' type='date' required>
            </div>
            <div>
                <label>Annees Experience</label>
                <input name='anneesExp' type='number' required>
            </div>
            <div>
                <label>Taux horaire</label>
                <input name='tauxHoraire' type='number' required>
            </div>
            <input value='OK' type='submit'>
        </form>
    </body>
</html>
