
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Config 
{
    static String user = "sa";
    static String password ="";
    static String url ="jdbc:h2:tcp://localhost/~/test";
    
    static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.h2.Driver");
        
        return DriverManager.getConnection(url, user,password);
    }
}
