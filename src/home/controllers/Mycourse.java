package home.controllers;

import home.util.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Mycourse implements Initializable {
    @FXML
    private ListView<String> list;

    private ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private AnchorPane rootpane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Connection Conn = ConnectionUtil.connectdb();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = Conn.createStatement();
            rs = stmt.executeQuery("SELECT concat(e.subjectName,'(',c.classID,') ') FROM uetcourse.students_subjects s INNER JOIN uetcourse.classes c on s.classID = c.classID INNER JOIN uetcourse.Subjects e on e.subjectID = c.subjectID");

            while (rs.next()) {
                items.add(rs.getString(1) );

            }
        } catch (SQLException e) {
                  e.printStackTrace();
        }
        list.setItems(items);


    }



    public void handleMouseClicked(javafx.scene.input.MouseEvent mouseEvent) {
        String str = list.getSelectionModel().getSelectedItem();
        AnchorPane pane;
        switch (str){
            case "Giai Tich 1(INT1002-23)":
                try {
                    pane =  FXMLLoader.load(getClass().getResource("/home/fxml/subject1.fxml"));
                    rootpane.getChildren().setAll(pane);
                }catch (IOException e){
                    e.printStackTrace();
                }
              break;
            case "Giai tich 2(INT1003-23)":
                try {
                    pane =  FXMLLoader.load(getClass().getResource("/home/fxml/subject2.fxml"));
                    rootpane.getChildren().setAll(pane);
                }catch (IOException e){
                    e.printStackTrace();
                }

        }
    }




    public ListView<String> getList() {
        return list;
    }

    /*  private ObservableList<StudentModel> oblist= FXCollections.observableArrayList(
                new StudentModel("INT2209","Mang May Tinh",3,"Tran Binh Trong"),
                new StudentModel("INT1002","Giai tich 1",3,"Le Phe Do"),
                new StudentModel("INT1003","Giai tich 2",3,"Le Phe Do"),
                new StudentModel ("INT2002","Phuong phap tinh",2,"Le Phe Do"),
                new StudentModel ("INT3002","Toan Roi Rac",4,"Le Phe Do"),

                new StudentModel ( "INT4002","Nhap Mon An Toan Thong Tin",3,"Le Phe Do")

        );
        */

}
