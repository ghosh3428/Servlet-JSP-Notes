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

@WebServlet(urlPatterns = {"/employeesalarydetails"})
public class EmployeeSalaryDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            String id = req.getParameter("e_id");

            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException ex) {

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
                    double basic = rs.getDouble(8);
                    double da = basic * 70 / 100;
                    double hra = basic * 35 / 100;
                    double ta = basic * 20 / 100;
                    double pf = basic * 13 / 100;
                    double net = basic + da + hra + ta - pf;
                    out.print("<div class=\"container mt-5 text-center\">\n"
                            + "            <table class=\"table table-bordered\" >\n"
                            + "                <tbody>\n"
                            + "                    <tr>\n"
                            + "                        <th scope=\"row\" class=\"fs-4\">Name</th>\n"
                            + "                        <td class=\"fs-4\">" + rs.getString(2) + " " + rs.getString(3) + " </td>\n"
                            + "                    </tr>\n"
                            + "                    <tr>\n"
                            + "                        <th scope=\"row\" class=\"fs-4\">Basic Salary</th>\n"
                            + "                        <td class=\"fs-4\">" + basic + "</td>\n"
                            + "                    </tr>\n"
                            + "                    <tr>\n"
                            + "                        <th scope=\"row\" class=\"fs-4\">DA</th>\n"
                            + "                        <td class=\"fs-4\">" + da + "</td>\n"
                            + "                    </tr>\n"
                            + "                    <tr>\n"
                            + "                        <th scope=\"row\" class=\"fs-4\">TA</th>\n"
                            + "                        <td class=\"fs-4\">" + ta + "</td>\n"
                            + "                    </tr>\n"
                            + "                    <tr>\n"
                            + "                        <th scope=\"row\" class=\"fs-4\">HRA</th>\n"
                            + "                        <td class=\"fs-4\">" + hra + "</td>\n"
                            + "                    </tr>\n"
                            + "                    <tr>\n"
                            + "                        <th scope=\"row\" class=\"fs-4\">PF</th>\n"
                            + "                        <td class=\"fs-4\">" + pf + " </td>\n"
                            + "                    </tr>\n"
                            + "                    <tr>\n"
                            + "                        <th scope=\"row\" class=\"fs-4\">Net Salary</th>\n"
                            + "                        <td class=\"fs-4\">" + net + "</td>\n"
                            + "                    </tr>\n"
                            + "                </tbody>\n"
                            + "\n"
                            + "            </table>");

                } else {
                    out.print("<h1 class='display-6 bg-danger text-white mt-5'>User Not Found : Incorrect ID</h1>");
                }

                con.close();
            } catch (SQLException ex) {

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
