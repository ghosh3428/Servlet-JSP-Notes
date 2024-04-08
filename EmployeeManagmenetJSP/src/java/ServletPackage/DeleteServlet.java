
package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "deleteServlet", urlPatterns = {"/deleteServlet"})
public class DeleteServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       Connection con = null;
        PreparedStatement pst = null;
        String query = "";
        
        String user = "sa";
        String password = "";
        String url = "jdbc:h2:tcp://localhost/~/test";

        try 
        {
            Class.forName("org.h2.Driver");
            
            con = DriverManager.getConnection(url,user,password);
            
            query = "delete from employee where id = ?;";
            
            pst = con.prepareStatement(query);
            
            pst.setString(1, request.getParameter("e_id"));
            
            
            pst.executeUpdate();
            con.close();
            request.setAttribute("success", "Employee Deleted Successfully.");
            request.getRequestDispatcher("/showallemployee.jsp").forward(request, response);
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            con.close();
            request.setAttribute("error", "!!! Error Deleting Employee. !!!");
            request.getRequestDispatcher("/showallemployee.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
