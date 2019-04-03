package home.controllers;

import home.util.ConnectionUtil;
import home.util.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Mycourse implements Initializable {
    @FXML
    Label info;


    @FXML
    private TableView<StudentModel> tndata;
    @FXML
    public TableColumn<StudentModel, Integer> creditsNum;

    @FXML
    public TableColumn<StudentModel, String> subjectName;

    @FXML
    public TableColumn<StudentModel, String> subjectId;
    @FXML
    public TableColumn<StudentModel, String> lecturerName;

    private ObservableList<StudentModel> oblist = FXCollections.observableArrayList();

    public Mycourse(){}




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        info.setText(Login.getInfo());

        try {
            Connection con = ConnectionUtil.connectdb();
            ResultSet rs = con.createStatement().executeQuery("SELECT subjectId,subjectName, creditsNum,lecturerName from students_subjects");
            while( rs.next()) {
                oblist.add(new StudentModel(rs.getString("subjectId"),rs.getString("subjectName"),rs.getInt("creditsNum"),rs.getString("lecturerName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        subjectId.setCellValueFactory(new PropertyValueFactory<>("SubjectId"));
        subjectName.setCellValueFactory(new PropertyValueFactory<>("SubjectName"));
        creditsNum.setCellValueFactory(new PropertyValueFactory<>("CreditsNum"));
        lecturerName.setCellValueFactory(new PropertyValueFactory<>("LecturerName"));
          tndata.setItems(oblist);
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
