/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ShowAllEmployeeServlet", urlPatterns = {"/showAllEmployee"})
public class ShowAllEmployeeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String user = "sa";
            String password = "";
            String url = "jdbc:h2:tcp://localhost/~/test";

            Connection con;
            try {
                Class.forName("org.h2.Driver");
                con = DriverManager.getConnection(url, user, password);
                String query = "Select * from employee;";
                Statement st = con.createStatement();
                
                ResultSet rs  = st.executeQuery(query);
                
                List <Employee> emplist = new ArrayList();
                
                while(rs.next())
                {
                    Employee e = new Employee();
                    
                    e.setId(rs.getInt(1));
                    e.setFirstName(rs.getString(2));
                    e.setLastName(rs.getString(3));
                    e.setAge(rs.getInt(4));
                    e.setBasic(rs.getDouble(8));
                    e.setDesignation(rs.getString(6));
                    e.setPhoneNumber(rs.getString(5));
                    e.setYearOfExperience(rs.getInt(7));
                    
                    
                    emplist.add(e);
                    
                }
                
                
                request.setAttribute("employeelist", emplist);
                request.getRequestDispatcher("/showallemployee.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
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
