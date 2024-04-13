
package Servlet;

import Model.User;
import Service.UserService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException
    {
        User player = new User();
        
        player.setActive(true);
        player.setFirstName(req.getParameter("user_fn"));
        player.setLastName(req.getParameter("user_ln"));
        player.setLoginId(req.getParameter("user_lid"));
        player.setPassword(req.getParameter("user_pass"));
        player.setRole("PLAYER");
        
        UserService service = new UserService();
        
        try {
            boolean result = service.addPlayer(player);
            
            if(result == true)
            {
                req.getRequestDispatcher("/success.html").forward(req, res);
            }
            else
            {
               req.getRequestDispatcher("/error.html").forward(req, res); 
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
