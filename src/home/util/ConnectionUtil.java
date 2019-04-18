package home.util;

import java.sql.*;
import javax.swing.*;

public class ConnectionUtil {
    // Ham ket noi database, gom ten user,mat khau
     Connection conn = null;
     public static Connection connectdb() {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/uetcourse","root","slowpoke");
             return conn;
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
             return null;
         }
     }
}
