/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nust.directory.controller;

import java.io.IOException;
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
 * @author khayelihle.tshuma
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        System.out.println("In Get");
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
            
                session.setAttribute("session_student", user_name);
            
                rd = request.getRequestDispatcher("/building.jsp");
                rd.forward(request, response);
            }
            else{
                System.out.println("Password Characters less than or equal to 0. ");
                rd = request.getRequestDispatcher("/adminlogin.jsp" );
                rd.forward(request, response);
                
            }
            
          
        } catch (Exception ex) {
            System.out.println("Authentication to Domain : staff.nust.ac.zw failed\n");
            System.out.println(ex.toString());
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            rd = request.getRequestDispatcher("/adminlogin.jsp");
            rd.forward(request, response);
        } 
        
    }

    
}
