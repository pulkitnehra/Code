/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublisherRecordsApp;
import java.sql.*;

/**
 *
 * @author nehra
 */
public class Conn {
    
    Statement s ;
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    public Conn() 
    {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/nikeproj","root","");
            s = cn.createStatement();
            
            
        } catch (Exception ex) {
            System.out.println("Problem establishing connection"+ex);
        } 
        
        
    
    }
            
    
}
