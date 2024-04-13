
package Service;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserService 
{
    public boolean addPlayer(User player) throws ClassNotFoundException, SQLException
    {
        Connection con = Config.getConnection();
        
        try
        {
            String query = "Insert into quiz_user (first_name , last_name , active,role,login_id,password) values(?,?,?,?,?,?);";
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
    
    public User login(String lid , String password) throws SQLException, ClassNotFoundException
    {
        Connection con = Config.getConnection();
        
        try
        {
            String query = "select * from quiz_user where login_id = ? and password = ? ; ";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setString(1, lid);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            User user = null;
            if (rs.next())
            {
                user = new User();
                user.setActive(rs.getBoolean(7));
                user.setFirstName(rs.getString(2));
                user.setId(rs.getInt(1));
                user.setLastName(rs.getString(3));
                user.setLoginId(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setRole(rs.getString(6));
            }
            
            con.close();
            return user; 
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            con.close();
            return null;
        }
    }
    
}
