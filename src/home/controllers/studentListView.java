package home.controllers;

import home.util.ConnectionUtil;
import home.util.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class studentListView implements Initializable {

    @FXML
    private TableView<StudentModel> table;
    @FXML
    private TableColumn<StudentModel,String> studId;
    @FXML
    private TableColumn<StudentModel,String> studName;
    @FXML
    private TableColumn<StudentModel, String> midTerm;
    @FXML
    private TableColumn<StudentModel, String> finalEx;
    @FXML
    private TableColumn<StudentModel, String> attendance;

    private ObservableList<StudentModel> listStudent = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildData();
        studId.setCellValueFactory(new PropertyValueFactory<>("studId"));
        studName.setCellValueFactory(new PropertyValueFactory<>("studName"));
        midTerm.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        midTerm.setCellFactory(TextFieldTableCell.forTableColumn());
        finalEx.setCellValueFactory(new PropertyValueFactory<>("finalEx"));
        finalEx.setCellFactory(TextFieldTableCell.forTableColumn());
        attendance.setCellValueFactory(new PropertyValueFactory<>("attendance"));
        attendance.setCellFactory(TextFieldTableCell.forTableColumn());
        handleEdit();
    }

    public void buildData(){
        Connection conn = ConnectionUtil.connectdb();
        String sql = "SELECT distinct ss.studentsId, s1.studentName, ss.midterm, ss.final, ss.attendance FROM uetcourse.students_subjects as ss\n" +
                "inner join uetcourse.studentsInfo as s1 inner join uetcourse.classes as c\n" +
                "where ss.studentsId = s1.studentId and ss.classId = ?";
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,myCourseTeacher.getClassID());
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                listStudent.add(new StudentModel(rs.getString(1), rs.getString(2), setupGrade(rs.getString(3)), setupGrade(rs.getString(4)), setupAttendance(rs.getString(5))));
            }
            table.setItems(listStudent);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void refresh(){
        listStudent.clear();
        table.getItems().clear();
        buildData();
    }

    public void updateDb(String sql, String str, String id){
        Connection con = ConnectionUtil.connectdb();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, str);
            preparedStatement.setString(2,id);
            preparedStatement.setString(3,myCourseTeacher.getClassID());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void handleEdit(){
        table.setEditable(true);
        table.getSelectionModel().cellSelectionEnabledProperty().set(true);

        midTerm.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<StudentModel, String> event) {
                String id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getStudId();
                System.out.println(id);
                ((StudentModel) event.getTableView().getItems().get(event.getTablePosition().getRow())).setMidterm(event.getNewValue());
                String str = event.getTableView().getItems().get(event.getTablePosition().getRow()).getMidterm();
                System.out.println(str);
                String sql = "UPDATE uetcourse.students_subjects SET midterm = ? WHERE studentsId = ? && classId = ?";
                updateDb(sql, str, id);
                refresh();
            }
        });
        finalEx.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<StudentModel, String> event) {
                String id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getStudId();
                System.out.println(id);
                ((StudentModel) event.getTableView().getItems().get(event.getTablePosition().getRow())).setFinalEx(event.getNewValue());
                String str = event.getTableView().getItems().get(event.getTablePosition().getRow()).getFinalEx();
                System.out.println(str);
                String sql = "UPDATE uetcourse.students_subjects SET final = ? WHERE studentsId = ? && classId = ?";
                updateDb(sql, str, id);
                refresh();
            }
        });
        attendance.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<StudentModel, String> event) {
                String id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getStudId();
                System.out.println(id);
                ((StudentModel) event.getTableView().getItems().get(event.getTablePosition().getRow())).setAttendance(event.getNewValue());
                String str = event.getTableView().getItems().get(event.getTablePosition().getRow()).getAttendance();
                System.out.println(str);
                String sql = "UPDATE uetcourse.students_subjects SET attendance = ? WHERE studentsId = ? && classId = ?";
                updateDb(sql, str, id);
                refresh();
            }
        });
    }

    private String setupGrade(String grade){
        if(Double.parseDouble(grade) >= 0){
        } else {
            grade = "Not yet grade";
        }
        return grade;
    }

    private String setupAttendance(String attendance){
        if(attendance == null){
            attendance = "0";
        }
        return attendance;
    }
}
