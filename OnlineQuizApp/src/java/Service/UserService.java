
package Service;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserService 
{
    public boolean addPlayer(User player) throws ClassNotFoundException, SQLException
    {
        Connection con = Config.getConnection();
        
        try
        {
            String query = "Insert into quiz_user (first_name , last_name , active,role,loginid,password) values(?,?,?,?,?,?);";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setString(1, player.getFirstName());
            pst.setString(2, player.getLastName());
            pst.setBoolean(3, player.isActive());
            pst.setString(4, player.getRole());
            pst.setString(5, player.getLoginId());
            pst.setString(6, player.getPassword());
            
            pst.executeUpdate();
            
            con.close();
            return true; 
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            con.close();
            return false;
        }
    }
    
}
