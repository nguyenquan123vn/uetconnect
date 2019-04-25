package home.controllers;

import home.util.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class myCourseTeacher implements Initializable {
    @FXML
    private ListView<String> list1;

    private ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private AnchorPane rootPane;
    @FXML
    protected Button newCoursebtn;
    @FXML
    protected Button viewCoursebtn;
    @FXML
    protected Button deleteCoursebtn;
    @FXML
    protected Button upload;
    @FXML
    protected Button viewStudentbtn;

    private String fileName = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Connection Conn = ConnectionUtil.connectdb();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = Conn.createStatement();
            rs = stmt.executeQuery("SELECT concat('(',c.classId, ') ', s.subjectName, ' - GV: ', l.lecturerName) FROM uetcourse.classes as c inner join uetcourse.Subjects as s inner join uetcourse.Lecturers as l where c.lecturerId = l.lecturerId and c.subjectId = s.subjectId;");

            while (rs.next()) {
                String str1 = rs.getString(1);
                items.add(str1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list1.setItems(items);
    }

    public void refresh(){
        Connection Conn1 = ConnectionUtil.connectdb();

        Statement stmt1 = null;
        ResultSet rs1 = null;
        try {
            stmt1 = Conn1.createStatement();
            rs1 = stmt1.executeQuery("SELECT concat(e.subjectName,'(',c.classID,') ') FROM uetcourse.students_subjects s INNER JOIN uetcourse.classes c on s.classID = c.classID INNER JOIN uetcourse.Subjects e on e.subjectID = c.subjectID");

            while (rs1.next()) {
                String str1 = rs1.getString(1);
                items.add(str1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list1.setItems(items);
    }

    public void delete (String str){
        Connection Conn = ConnectionUtil.connectdb();
        try {
            PreparedStatement stmt = Conn.prepareStatement("DELETE FROM uetcourse.classes Where classId =?");
            stmt.setString(1,str);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleFunctions(ActionEvent actionEvent) throws  IOException{
        String str = list1.getSelectionModel().getSelectedItem();
        int index = list1.getSelectionModel().getSelectedIndex();
        if(actionEvent.getSource() == viewCoursebtn) {

        } else if(actionEvent.getSource() == newCoursebtn) {

        } else if(actionEvent.getSource() == deleteCoursebtn) {
            String substr =  str.substring(1,11);
            System.out.println(substr);
            list1.getItems().remove(index);
            delete(substr);
        } else if(actionEvent.getSource() == upload) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){
                fileName = selectedFile.getAbsolutePath();
                System.out.println(fileName);
                ConnectionUtil.uploadBlob(2, fileName, "INT1002");
            }
        } else if(actionEvent.getSource() == viewStudentbtn) {
        }
    }

    /* public void fileChooser(javafx.event.ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            fileName = selectedFile.getAbsolutePath();
            System.out.println(fileName);
            ConnectionUtil.uploadBlob(2, fileName, "INT1002");
        }
    } */



    public ListView<String> getList() {
        return list1;
    }

}
