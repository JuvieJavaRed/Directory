/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nust.directory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ldap.LdapContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nust.directory.model.PortalAuthenticator;

/**
 *
 * @author avlab6
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        System.out.println("In Login Controller \n");
       
        RequestDispatcher rd = null;
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
                
        request.setAttribute("user_name", user_name);
        
        try {
            
            if(! (password.length() <= 0) ){
                LdapContext ctx = PortalAuthenticator.getConnection(user_name, password , "196.220.119.38");
                ctx.close();
                System.out.println("Authentication to Domain : staff.nust.ac.zw  For : " + user_name + "  Successful\n");
           
                
                HttpSession session = request.getSession() ;
            
                session.setAttribute("session_user_name", user_name);
            
                rd = request.getRequestDispatcher("/adminlanding.jsp");
                rd.forward(request, response);
            }
            else{
                System.out.println("Password Characters less than or equal to 0. ");
                rd = request.getRequestDispatcher("/adminlogin.jsp" );
                rd.forward(request, response);
                
            }
            
          
        } catch (Exception ex) {
            System.out.println("Authentication to Domain : staff.nust.ac.zw failed\n");
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            rd = request.getRequestDispatcher("/adminlogin.jsp");
            rd.forward(request, response);
        } 
        
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
