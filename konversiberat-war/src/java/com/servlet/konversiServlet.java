/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.konversiberat;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class konversiServlet extends HttpServlet {

    @EJB
    private konversiberat konversiberat;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body");
            out.println("<h1><center>Tugas RSBK MODUL 2</center></h1>");
            String biling = request.getParameter("biling");
            
            if ((biling != null) && (biling.length() > 0)) {
                double d = Double.parseDouble(biling);
                if (request.getParameter("Personal") != null){
                    String cefa = konversiberat.personal(d);
                    out.println("<p> TOTAL HARGA: "+cefa+"</p>");
                }  
                if (request.getParameter("Paket Malam") != null) {
                    String cere = konversiberat.paket_Malam(d);
                    out.println("<p> TOTAL HARGA: "+cere+ " .</p>");
                }
                if (request.getParameter("Paket Biasa") != null) {
                    String rece = konversiberat.paket_biasa(d);
                    out.println("<p> TOTAL HARGA: " +rece+ " .</p>");
                }
                
                
            } else {
                out.println("<center>");
                out.println("<p>Maukkan Jam:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"biling\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Personal\" value=\"Personal\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Paket Malam\" value=\"Paket Malam\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Paket Biasa\" value=\"Paket Biasa\">");
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
