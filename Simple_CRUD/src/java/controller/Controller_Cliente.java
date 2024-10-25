/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import br.com.commandfactory.controller.ICommand;
import dao.ClienteDAO;
import facade.ControleFacadeWeb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import java.io.PrintWriter;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "Controller_Cliente", urlPatterns = {"/Controller_Cliente"})
public class Controller_Cliente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            ControleFacadeWeb cfw = new ControleFacadeWeb();
            cfw.acionar(request, response);
        }
        /* 
        -> Este código agora fica na classe ControleFacadeWeb!
        
        try (PrintWriter out = response.getWriter()) {
            try{
                String paramAction = request.getParameter("btnoperacao");
                String nomeDaClasse = "br.com.commandfactory.controller." + paramAction + "ClienteAction";
                Class classeAction = Class.forName(nomeDaClasse);
                ICommand commandAction = (ICommand) classeAction.newInstance();
                String pageDispatcher = commandAction.executar(request, response);
                request.getRequestDispatcher("/" + pageDispatcher).forward(request, response);
            }catch(Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
                request.setAttribute("erro", ex.getMessage());
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }*/
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
