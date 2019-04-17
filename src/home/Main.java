package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    //load san khau chinh
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        primaryStage.setTitle("");
        Image icon = new Image(getClass().getResourceAsStream("/home/image/icon.PNG"));primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, 632.0, 642.0));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
