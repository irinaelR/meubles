/*
 * Click nbfs://nbhost/SystemFileSystem/lates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/lates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Model.TailleParCategorieParStyle;
import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author Irina
 */
public class RecuperationTailleCategorieStyle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try (PrintWriter out = response.getWriter()) {
             Connexion connexion = new Connexion();
            
            try{
                
                String idCategorie = (request.getParameter("categorie"));
                String idStyle = (request.getParameter("style"));
                int petit = -1;
                int grand = -1;
                String[] listeVolume= request.getParameterValues("petit[]");

               for(int i=0 ; i<listeVolume.length ; i++){
                   out.println("=--"+listeVolume[i]);
                    
               }
               new TailleParCategorieParStyle().insertions(null, idCategorie, idStyle, listeVolume);




            }catch(Exception e){
                out.println(e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
