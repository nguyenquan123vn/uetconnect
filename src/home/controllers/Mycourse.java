package home.controllers;

import home.util.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Mycourse implements Initializable {
    @FXML
    private ListView<String> list;
    @FXML
    private AnchorPane rootpane;

    private static String classID;
    private ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Connection Conn = ConnectionUtil.connectdb();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = Conn.createStatement();
            rs = stmt.executeQuery("SELECT distinct concat('(',c.classID,') ', s1.subjectName, '- So tin chi: ', s1.creditsNum, '- GV: ', l.lecturerName) \n" +
                    "FROM uetcourse.students_subjects s \n" +
                    "INNER JOIN uetcourse.classes c on s.classID = c.classID \n" +
                    "INNER JOIN uetcourse.Subjects as s1 \n" +
                    "Inner join uetcourse.Lecturers as l on s1.subjectID = c.subjectID and l.lecturerId = c.lecturerId\n");
            while (rs.next()) {
                String str1 = rs.getString(1);
                items.add(str1);
            }
        } catch (SQLException e) {
                  e.printStackTrace();
        }
        list.setItems(items);
    }

    public void handleMouseClicked(javafx.scene.input.MouseEvent mouseEvent) {
        int index = list.getSelectionModel().getSelectedIndex();
        String item = list.getSelectionModel().getSelectedItem();
        classID = item.substring(1,11);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/home/fxml/studentCourseView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle(item);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getclassID(){
        return classID;
    }

    public ListView<String> getList() {
        return list;
    }
}
