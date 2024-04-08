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

@WebServlet(name = "addEmployeeServlet", urlPatterns = {"/addEmployeeServlet"})
public class AddEmployeeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, SQLException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
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
                String query = "insert into employee(firstname , lastname , age , phone, designation , experience , salary) values(?,?,?,?,?,?,?)";

                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, fn);
                pst.setString(2, ln);
                pst.setString(3, age);
                pst.setString(4, phone);
                pst.setString(5, desig);
                pst.setString(6, exp);
                pst.setString(7, sal);

                pst.executeUpdate();

                con.close();
                
                req.setAttribute("success", "Data Added Successfully");
                req.getRequestDispatcher("/employeeAdd.jsp").forward(req, res);
            } 
            catch (SQLException ex) 
            {
                con.close();
                req.setAttribute("error", "Error Adding Data");
                req.getRequestDispatcher("/employeeAdd.jsp").forward(req, res);
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
