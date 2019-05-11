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

    private String studId, studName, midterm, finalEx, attendance;

    public StudentModel(){}

    public StudentModel(String studId, String studName, String midterm, String finalEx, String attendance){
        this.studId = studId;
        this.studName = studName;
        this.midterm = midterm;
        this.finalEx = finalEx;
        this.attendance = attendance;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getFinalEx() {
        return finalEx;
    }

    public void setFinalEx(String finalEx) {
        this.finalEx = finalEx;
    }

    public String getMidterm() {
        return midterm;
    }

    public void setMidterm(String midterm) {
        this.midterm = midterm;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }
}
