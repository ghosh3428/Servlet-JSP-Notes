/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet( urlPatterns = {"/viewAllEmployee"})
public class ViewAllEmployee extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
        
        
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            
        }
        
        String user = "sa";
        String password ="";
        String url = "jdbc:h2:tcp://localhost/~/test";
        
        Connection con;
        try {
            con = DriverManager.getConnection(url, user, password);
            String query = "Select * from employee";
        
        PreparedStatement pst = con.prepareStatement(query);
        

        ResultSet rs = pst.executeQuery();
        
        
       
        while(rs.next())
        {
        out.print("Employee Id         : " + rs.getString(1)+"</br>");
        out.print("First Name          : " + rs.getString(2)+"</br>");
        out.print("Last Name           :" + rs.getString(3)+"</br>");
        out.print("Age                 : " + rs.getString(4)+"</br>");
        out.print("Phone Number        : " + rs.getString(5)+"</br>");
        out.print("Designation         : " + rs.getString(6)+"</br>");
        out.print("Years of Experience : " + rs.getString(7)+"</br>");
        out.print("Basic Salary        :" + rs.getString(8)+"</br>");
        out.print("-----------------------------------------------------------------------------------<br/>");
        }
       
        out.print("<a href='index.html'>Return To Home</a>");
        con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
