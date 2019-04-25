package home.util;

import java.io.*;
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

     public static void uploadBlob(int week,String fileName, String subjectId){
         String upload = "UPDATE subject_content SET content = ? WHERE week = ? AND subjectId = ?";
         try {
             Connection conn = ConnectionUtil.connectdb();
             PreparedStatement prepStatement = conn.prepareStatement(upload);

             File file = new File(fileName);
             FileInputStream input = new FileInputStream(file);

             prepStatement.setBinaryStream(1, input);
             prepStatement.setInt(2, week);
             prepStatement.setString(3,subjectId);
             System.out.println("Reading file " + file.getAbsolutePath());
             System.out.println("Store file in the database.");
             prepStatement.executeUpdate();

         } catch (SQLException | FileNotFoundException e){
             System.out.println( e.getMessage() );
         }
     }

     public static void readBlob(int week, String subjectId){
         String readBlob = "SELECT content FROM subject_content WHERE week = ? AND subjectId = ?";
         ResultSet rs = null;
         try {
             Connection conn = ConnectionUtil.connectdb();
             PreparedStatement prepStatement = conn.prepareStatement(readBlob);

             prepStatement.setInt(1, week);
             prepStatement.setString(2,subjectId);
             rs = prepStatement.executeQuery();
             String fileName = "a";
             File file = new File(fileName);
             FileOutputStream output = new FileOutputStream(file);
             System.out.println("Writing BLOB to file " + file.getAbsolutePath());

             while (rs.next()) {
                 InputStream input = rs.getBinaryStream("content");
                 byte[] buffer = new byte[1024];
                 while (input.read(buffer) > 0) {
                     output.write(buffer);
                 }
             }
         } catch (SQLException | IOException e){
            e.printStackTrace();
         }
     }
}
