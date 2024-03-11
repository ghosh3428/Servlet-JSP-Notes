package MyPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/updateemployee")
public class UpdateEmployee extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String fn = req.getParameter("e_fn");
        String ln = req.getParameter("e_ln");
        String age = req.getParameter("e_age");
        String phone = req.getParameter("e_phone");
        String desig = req.getParameter("e_desig");
        String exp = req.getParameter("e_exp");
        String sal = req.getParameter("e_sal");
        int id = Integer.parseInt(req.getParameter("e_id"));

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
            String query = "update employee set firstname = ? , lastname = ? , age = ? , phone = ?, designation = ? , experience = ? , salary = ? where id = ?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, fn);
            pst.setString(2, ln);
            pst.setString(3, age);
            pst.setString(4, phone);
            pst.setString(5, desig);
            pst.setString(6, exp);
            pst.setString(7, sal);
            pst.setInt(8, id);

            pst.executeUpdate();

            con.close();

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.print("<link href='bootstrap.css' rel='stylesheet' />");
            out.print("<nav class=\"navbar navbar-expand-md\" style=\"background: linear-gradient(90deg, rgba(23,0,36,1) 0%, rgba(83,9,121,1) 38%, rgba(0,212,255,1) 100%);\">\n"
                    + "            <div class=\"container\">\n"
                    + "                <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n"
                    + "                    <ul class=\"nav navbar-nav \">\n"
                    + "                        <li class=\"nav-item active\"><a class=\"nav-link fs-5 fw-bold text-white\" href=\"index.html\">Home </a></li>\n"
                    + "                        <li class=\"nav-item active\"><a class=\"nav-link fs-5 fw-bold text-white\" href=\"employeeaddform.html\">Add </a></li>\n"
                    + "                        <li class=\"nav-item active\"><a class=\"nav-link fs-5 fw-bold text-white\" href=\"employeesearchform.html\">Search</a></li>\n"
                    + "                        <li class=\"nav-item active\"><a class=\"nav-link fs-5 fw-bold text-white\" href=\"employeedeleteform.html\">Delete </a></li>\n"
                    + "                        <li class=\"nav-item active\"><a class=\"nav-link fs-5 fw-bold text-white\" href=\"employeeupdate.html\">Update </a></li>\n"
                    + "                        <li class=\"nav-item active\"><a class=\"nav-link fs-5 fw-bold text-white\" href=\"employeesalarysearchform.html\">Salary Details </a></li>\n"
                    + "                        <li class=\"nav-item active\"><a class=\"nav-link fs-5 fw-bold text-white\" href=\"viewAllEmployee\">Show All </a></li>\n"
                    + "                    </ul>\n"
                    + "\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </nav>");
            out.print("<div class='container pt-5'>");
            out.print("<h1 class='bg-success text-white display-5 text-center'>Employee Updated Successfully</h1>");
            

        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
