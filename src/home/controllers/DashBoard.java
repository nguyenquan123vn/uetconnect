package home.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoard implements Initializable {

    @FXML
    private Button btnMycourse;

    @FXML
    private Button btnMyhome;

    @FXML
    private Button btn_Timetable;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnClasses;

    @FXML
    private Label info;
    @FXML
    private AnchorPane parent;


    //su kien click chon chuc nang o nut home
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent)  {
        if (mouseEvent.getSource() == btnMyhome) {
            loadStage("/home/fxml/myhome.fxml");

        } else if (mouseEvent.getSource() == btnMycourse) {
            loadStage("/home/fxml/mycourse.fxml");
        } else if (mouseEvent.getSource() == btn_Timetable) {
            loadStage("/home/fxml/timetable.fxml");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        info.setText(Login.getInfo());
    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Image icon = new Image(getClass().getResourceAsStream("/home/image/icon.PNG"));
            stage.getIcons().add(icon);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
