
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


@WebServlet(name = "updateEmployeeServlet", urlPatterns = {"/updateEmployeeServlet"})
public class UpdateEmployeeServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, SQLException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) 
        {
            String id = req.getParameter("e_id");
            String fn = req.getParameter("e_fn");
            String ln = req.getParameter("e_ln");
            String age = req.getParameter("e_age");
            String phone = req.getParameter("e_phone");
            String desig = req.getParameter("e_desig");
            String exp = req.getParameter("e_exp");
            String sal = req.getParameter("e_sal");

            String user = "sa";
            String password = "";
            String url = "jdbc:h2:tcp://localhost/~/test";
            Connection con = null;

            try {
                Class.forName("org.h2.Driver");

                con = DriverManager.getConnection(url, user, password);
                String query = "update employee set firstname = ? , lastname = ? ,age = ? , designation = ? , phone = ? , salary = ? , experience = ? where id = ?";

                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, fn);
                pst.setString(2, ln);
                pst.setString(3, age);
                pst.setString(5, phone);
                pst.setString(4, desig);
                pst.setString(7, exp);
                pst.setString(6, sal);
                pst.setString(8, id);

                pst.executeUpdate();

                con.close();
                
                req.setAttribute("success", "Data Added Successfully");
                req.getRequestDispatcher("/employeeupdate.jsp").forward(req, res);
            } 
            catch (SQLException ex) 
            {
                con.close();
                req.setAttribute("error", "Error Adding Data");
                req.getRequestDispatcher("/employeeupdate.jsp").forward(req, res);
            } 
            catch (ClassNotFoundException ex) {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
