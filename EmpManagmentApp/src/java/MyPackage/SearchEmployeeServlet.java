package MyPackage;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/searchemployee")
public class SearchEmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
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
            if (rs.next()) {
                
                out.print("<div class=\"container mt-5 \">\n" +
"            <div class=\"card\">\n" +
"                <div class=\"card-header bg-primary\">\n" +
"                    <h1 class=\"display-5 text-white text-center\">\n" +
"                        Employee Details\n" +
"                    </h1>\n" +
"                </div>\n" +
"                <div class=\"card-body\">\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-3 col-3 text-center text-light\">Employee ID</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(1) + "</label>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-3 col-3 text-center text-light\">First Name</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(2) + "</label>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-3 col-3 text-center text-light\">Last  Name</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(3) + "</label>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-3 col-3 text-center text-light\">Designation</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(6) + "</label>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-3 col-3 text-center text-light\">Age</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(4) + "</label>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-3 col-3 text-center text-light\">Phone Number</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(5) + "</label>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-2 col-4 text-center text-light\">Year of Experience</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(7) + "</label>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <label class=\"fs-3 offset-3 col-3 text-center text-light\">Basic Salary</label>\n" +
"                        <label class=\"fs-3 col-3 text-center text-warning\">" + rs.getString(8) + "</label>\n" +
"                    </div>\n" +
"                    \n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"        </div>");
                    
            } else {
                out.print("<h1 class='bg-danger text-white display-5 text-center mt-5'>Employee not found : Incorrect ID</h1>");
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
