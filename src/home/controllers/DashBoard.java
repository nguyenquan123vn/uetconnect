package home.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoard implements Initializable {


    @FXML
    private Button btnMyhome;

    @FXML
    private Button btnMycourse;

    @FXML
    private Button btntimetable;

    @FXML
    private Button btndoc;

    @FXML
    private Button btnnews;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;
    @FXML
    private Pane pane;
    @FXML
    private AnchorPane homePane;


    @FXML
    private Label info;
    @FXML
    private AnchorPane parent;


    //su kien click chon chuc nang o nut home
   /* @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent)  {
        if (mouseEvent.getSource() == btnMyhome) {
            loadStage("/home/fxml/myhome.fxml");

        } else if (mouseEvent.getSource() == btnMycourse) {
            loadStage("/home/fxml/mycourse.fxml");
        } else if (mouseEvent.getSource() == btn_Timetable) {
            loadStage("/home/fxml/timetable.fxml");
        }

    }
    */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        info.setText(Login.getInfo());
    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
         //   Image icon = new Image(getClass().getResourceAsStream("/home/image/icon.PNG"));
          //  stage.getIcons().add(icon);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnMyhome) {
            this.createPage(parent,"/home/fxml/myhome.fxml");
        }
        else if(actionEvent.getSource() == btnMycourse) {
            this.createPage(parent,"/home/fxml/mycourse.fxml");
        }
        else if (actionEvent.getSource() == btntimetable) {
            this.createPage(parent,"/home/fxml/timetable.fxml");
        }
        else if (actionEvent.getSource()== btnSettings){
            pane.setStyle("-fx-background-color : #464F67");
            pane.toFront();
        }
        else if(actionEvent.getSource() == btndoc){

        }
        else if(actionEvent.getSource() == btnnews){
            pane.setStyle("-fx-background-color : #1CFA23");
            pane.toFront();
        }

    }
    /*
    public class ScreenController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    protected void addScreen(String name, Pane pane){
         screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    protected void activate(String name){
        main.setRoot( screenMap.get(name) );
    }
}
ScreenController screenController = new ScreenController(scene);
screenController.add("calculator", FXMLLoader.load(getClass().getResource( "calculator.fxml" )));
screenController.add("testSwitch", FXMLLoader.load(getClass().getResource( "TestSwitch.fxml" )));
screenController.activate("calculator");
     */
    public void setNode(Node node){
        pane.getChildren().clear();
        pane.getChildren().add((Node)node);
    }
    public void createPage(AnchorPane home, String path) throws IOException {
        home = FXMLLoader.load(getClass().getResource(path));
        setNode(home);
    }
    @FXML
    void scene1Action(ActionEvent event) throws IOException {
        this.createPage(homePane,"/home/fxml/myhome.fxml");
    }
    @FXML
    void scene2Action(ActionEvent event) throws IOException {
        this.createPage(homePane,"/home/fxml/mycourse.fxml");
    }
}
