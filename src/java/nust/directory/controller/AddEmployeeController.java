/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nust.directory.controller;


import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nust.directory.model.Employee;

/**
 *
 * @author mthokozisi.nyoni
 */
public class AddEmployeeController extends HttpServlet {

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
            out.println("<title>Servlet AddEmployeeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddEmployeeController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        System.out.println("Start of AddBuildingController \n");
        HttpSession session = request.getSession();
        Employee Employee = (Employee) session.getAttribute("employee");
        Employee u= new Employee ();
        RequestDispatcher rd = null;
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String employee_id = request.getParameter("employee_id");
        String job_title = request.getParameter("job_title");
        String email_address = request.getParameter("email_address");
        String extension = request.getParameter("extension");
        String title = request.getParameter("title");
        String department_id = request.getParameter("department_id");
        String floor = request.getParameter("floor");
        String office_number = request.getParameter("office_number");
        
        int building_id = parseInt(request.getParameter("building_id"));
       
        try{
       u.addEmployee(name, surname, employee_id, job_title, email_address, extension, title, department_id, floor, office_number,building_id);
       u.view_employee();
       List<Employee> ls = u.view_employee();
        request.setAttribute("listEmployee" , ls);
        rd = request.getRequestDispatcher("/employee.jsp");
                rd.forward(request, response);
        }catch(Exception  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            rd = request.getRequestDispatcher("/employeecreate.jsp");
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
