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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = "/updateemployeesearch")
public class EmployeeUpdateSearch extends HttpServlet {

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
            out.print("<div class='container pt-5'>");
            if (rs.next()) {
                out.print("<div class=\"card\">\n"
                        + "                <div class=\"card-header\">\n"
                        + "                    <h1 class=\"display-4 bg-primary text-white text-center\"> Update Employee Form</h1>\n"
                        + "                </div>\n"
                        + "                <div class=\"card-body\">\n"
                        + "                    <form method=\"post\" action=\"updateemployee\">\n"
                        + "                        <div class=\"form-group row\">\n"
                        + "                            <label for=\"e_fn\" class=\"col-md-4 fs-3 text-center\">First Name</label>\n"
                        + "                            <div class=\"col-md-8\">\n"
                        + "                                <input type=\"text\" name=\"e_fn\" id=\"e_fn\" class=\"form-control\" value='" + rs.getString(2) + "'/>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"form-group row\">\n"
                        + "                            <label for=\"e_ln\" class=\"col-md-4 fs-3 text-center\">Last Name</label>\n"
                        + "                            <div class=\"col-md-8\">\n"
                        + "                                <input type=\"text\" name=\"e_ln\" id=\"e_ln\" class=\"form-control\" value='" + rs.getString(3) + "' />\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"form-group row\">\n"
                        + "                            <label for=\"e_age\" class=\"col-md-4 fs-3 text-center\">Age</label>\n"
                        + "                            <div class=\"col-md-8\">\n"
                        + "                                <input type=\"number\" name=\"e_age\" id=\"e_age\" class=\"form-control\" value='" + rs.getString(4) + "'/>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"form-group row\">\n"
                        + "                            <label for=\"e_phone\" class=\"col-md-4 fs-3 text-center\">Phone</label>\n"
                        + "                            <div class=\"col-md-8\">\n"
                        + "                                <input type=\"text\" name=\"e_phone\" id=\"e_phone\" class=\"form-control\" value='" + rs.getString(5) + "' />\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"form-group row\">\n"
                        + "                            <label for=\"e_desig\" class=\"col-md-4 fs-3 text-center\">Designation</label>\n"
                        + "                            <div class=\"col-md-8\">\n"
                        + "                                <input type=\"text\" name=\"e_desig\" id=\"e_desig\" class=\"form-control\" value='" + rs.getString(6) + "' />\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"form-group row\">\n"
                        + "                            <label for=\"e_exp\" class=\"col-md-4 fs-3 text-center\">Years Of Experience</label>\n"
                        + "                            <div class=\"col-md-8\">\n"
                        + "                                <input type=\"number\" name=\"e_exp\" id=\"e_exp\" class=\"form-control\" value='" + rs.getString(7) + "'/>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"form-group row\">\n"
                        + "                            <label for=\"e_sal\" class=\"col-md-4 fs-3 text-center\">Basic Salary</label>\n"
                        + "                            <div class=\"col-md-8\">\n"
                        + "                                <input type=\"text\" name=\"e_sal\" id=\"e_sal\" class=\"form-control\" value='" + rs.getString(8) + "'/>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"form-group \">\n"
                        + "                            <div class=\"text-center\">\n"
                        + "<input type='hidden' value='"+rs.getInt(1)+"' name = 'e_id'/>"
                        + "                                <input type=\"submit\" value=\"Update Employee\" class=\"btn btn-lg btn-success\"/>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </form>\n"
                        + "                </div>\n"
                        + "            </div>");
            } else {
                out.print("<h1 class='bg-danger text-white display-5 text-center mt-5'>Employee not found : Incorrect ID</h1>");
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
