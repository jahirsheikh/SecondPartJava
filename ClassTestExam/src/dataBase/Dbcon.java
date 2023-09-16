
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dbcon {
    
    private  Connection con = null;
    
    private String url = "";
    private String user = "";
    private String pssword = "";
    private String driver = "";
    
    public Connection getcon(){
    
        try {
            Class.forName(driver);
            
            con= DriverManager.getConnection(url, user, pssword);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbcon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbcon.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
    
}
