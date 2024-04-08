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

@WebServlet(name = "updateServlet", urlPatterns = {"/updateServlet"})
public class UpdateServlet extends HttpServlet {

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
            
            query = "update employee set firstname = ? , lastname = ? , age = ? , phone = ? , designation=? , experience = ? , salary = ? where id = ?;";
            
            pst = con.prepareStatement(query);
            
            pst.setString(1, request.getParameter("e_fn"));
            pst.setString(2, request.getParameter("e_ln"));
            pst.setString(3, request.getParameter("e_age"));
            pst.setString(4, request.getParameter("e_phone"));
            pst.setString(5, request.getParameter("e_desig"));
            pst.setString(6, request.getParameter("e_exp"));
            pst.setString(7, request.getParameter("e_sal"));
            pst.setString(8, request.getParameter("e_id"));
            
            
            pst.executeUpdate();
            con.close();
            request.setAttribute("success", "Employee Info Updated Successfully.");
            request.getRequestDispatcher("/showallemployee.jsp").forward(request, response);
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            con.close();
            request.setAttribute("error", "!!! Error Updating Employee Info. !!!");
            request.getRequestDispatcher("/showallemployee.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
