package home.util;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentModel {

    public SimpleStringProperty studentId = new SimpleStringProperty();
    public SimpleStringProperty studentName = new SimpleStringProperty();
    public SimpleStringProperty grade = new SimpleStringProperty();
    public SimpleStringProperty classId = new SimpleStringProperty();

    public StudentModel(){}

    public StudentModel(String studId, String studName, String grade){
        this.studentId = new SimpleStringProperty(studId);
        this.studentName = new SimpleStringProperty(studName);
        this.grade = new SimpleStringProperty(grade);
    }

    public void setClassId(String classId) {
        this.classId.set(classId);
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public void setStudentId(String studentId) {
        this.studentId.set(studentId);
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public String getStudentId() {
        return studentId.get();
    }

    public SimpleStringProperty studentIdProperty() {
        return studentId;
    }

    public String getStudentName() {
        return studentName.get();
    }

    public SimpleStringProperty studentNameProperty() {
        return studentName;
    }

    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }

    public String getClassId() {
        return classId.get();
    }

    public SimpleStringProperty classIdProperty() {
        return classId;
    }
}
