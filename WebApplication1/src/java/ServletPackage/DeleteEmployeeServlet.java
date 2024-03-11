
package ServletPackage;

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

@WebServlet(urlPatterns = {"/deleteEmployeeServlet"})
public class DeleteEmployeeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            String id = req.getParameter("e_id");

            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            String user = "sa";
            String password = "";
            String url = "jdbc:h2:tcp://localhost/~/test";

            Connection con;
            try {
                con = DriverManager.getConnection(url, user, password);
                String query = "Select * from employee where id = ?";

                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, id);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) 
                {
                    query = "delete from employee where id = ?";

                    pst = con.prepareStatement(query);
                    pst.setString(1, id); 
                    
                    pst.executeUpdate();
                    
                   req.setAttribute("success", "Data Deleted Successfully");
                   req.getRequestDispatcher("/employeeDelete.jsp").forward(req, res);
                } 
                else 
                {
                   req.setAttribute("error", "!!! Error : Incorrect ID !!!"); 
                   req.getRequestDispatcher("/employeeDelete.jsp").forward(req, res);
                }
                
                con.close();
                
                
            } 
            catch (SQLException ex) 
            {
               req.setAttribute("error", "!!! Error : SQL ERROR!!!"); 
                   req.getRequestDispatcher("/employeeDelete.jsp").forward(req, res); 
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
