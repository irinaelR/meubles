<%-- 
    Document   : affichageEmpProfilActuel
    Created on : 23 janv. 2024, 16:40:23
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employes</h1>
        <%
        
        ArrayList<Object> listeEmp = request.getAttribute("listeemploye");
        
        %>
        <table>
            <tr>
                <th>Nom Employe</th>
                <th>Date Embauche</th>
                <th>Nom Profil</th>
                <th>Experience</th>
                <th>Salaire Base</th>
            </tr>
            <%
                for(Object o : listeEmp) {
                    Emp e = (Emp) o;
                    Profil p = e.getProfilNow();
                    
                    out.println("<tr>");
                    out.println("<td>" + e.getNom() + "</td>");
                    out.println("<td>" + e.getDateEmbauche().toString() + "</td>");
                    out.println("<td>" + p.getNom() + "</td>");
                    out.println("<td>" + p.getExp() + "</td>");
                    out.println("<td>" + p.getSalaireBase() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
