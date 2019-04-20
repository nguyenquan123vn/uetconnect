package home.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherHome implements Initializable{

    @FXML
    protected Label infoTeacher;

    //set ten techer sau khi dang nhap thanh cong

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infoTeacher.setText("Lecturer " + Login.getInfo());
    }


}
