<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            input {
                display: block;
            }
        </style>
    </head>
    <body>
        <form action="InsertionClientTraitement" method="get">
            <H2>Insertion client</H2>
            <label for="">Nom : </label>
            <input type="text" name="nom" id="">

            <label for="">Prenom : </label>
            <input type="text" name="prenom" id="">

            <label for="">Date Naissance : </label>
            <input type="date" name="dateNaissance" id="">

            <label for="">Genre : </label>
            <select name="genre" >
                <option value="1"> Homme</option>
                <option value="2"> Femme</option>

            </select>

            <input type="submit" value="Valider">
        </form>
    </body>
</html>
