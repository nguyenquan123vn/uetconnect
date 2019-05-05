package home.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import static java.awt.Desktop.getDesktop;

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
         String upload = "UPDATE subject_content SET nameDoc = ? , content = ? WHERE week = ? AND subjectId = ?";
         try {
             Connection conn = ConnectionUtil.connectdb();
             PreparedStatement prepStatement = conn.prepareStatement(upload);

             File file = new File(fileName);
             FileInputStream input = new FileInputStream(file);
             String filename = file.getName();
             System.out.println(filename);
             prepStatement.setString(1,filename);
             prepStatement.setBinaryStream(2, input);
             prepStatement.setInt(3, week);
             prepStatement.setString(4,subjectId);
             System.out.println("Reading file " + file.getAbsolutePath());
             System.out.println("Store file in the database.");
             prepStatement.executeUpdate();
         } catch (SQLException | FileNotFoundException e){
             System.out.println( e.getMessage() );
         }
     }

     public static void readBlob(String week, String subjectId){
         String readBlob = "SELECT content FROM subject_content WHERE week = ? AND subjectId = ?";
         ResultSet rs = null;
         try {
             Connection conn = ConnectionUtil.connectdb();
             PreparedStatement prepStatement = conn.prepareStatement(readBlob);

             prepStatement.setString(1, week);
             prepStatement.setString(2,subjectId);
             rs = prepStatement.executeQuery();
             String fileName = "a.pdf";
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
             if (Desktop.isDesktopSupported()) {
                 new Thread(() -> {
                     try {
                         getDesktop().open(file);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }).start();
             }
         } catch (SQLException | IOException e){
            e.printStackTrace();
         }
     }

     public static void updateData(String column, String newValue, String Id){
         Connection con = ConnectionUtil.connectdb();
         try {
             PreparedStatement preState = con.prepareStatement("Update uetcourse.students_subjects Set" + column + "= ? WHERE classId = ?");
             preState.setString(1,newValue);
             preState.setString(2,Id);
             preState.executeUpdate();
         } catch (SQLException e){
             e.printStackTrace();
         }
     }
}
