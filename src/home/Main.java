package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    private double height;
    private double width;
    private Stage preloaderStage;

    //load san khau chinh
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.preloaderStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        primaryStage.setTitle("");
        Image icon = new Image(getClass().getResourceAsStream("/home/image/icon.png"));primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, 632.0, 570.0));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
