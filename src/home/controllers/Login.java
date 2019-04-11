package home.controllers;

import home.util.ConnectionUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class Login implements Initializable {

    protected static String info = "";
    protected static String profession = "";
    @FXML
    protected TextField textEmail;
    @FXML
    ProgressBar progressBar;
    @FXML
    protected PasswordField textPassword;


    Stage dialogStage = new Stage();


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public Login() {
        connection = ConnectionUtil.connectdb();
    }

    public void sayHelloButton(javafx.event.ActionEvent event){
        loadStage("/home/fxml/SayHello.fxml");
    }


    //Ham login
    public void loginAction(javafx.event.ActionEvent event){
        String username = textEmail.getText().toString();
        String password = textPassword.getText().toString();

        String sql = "SELECT * FROM account WHERE username = ? and password = ?";
        //Chon lay thong tin email tu acccount va password, cung cac thong tin khac tu bang

              try {
                  preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setString(1, username);
                  preparedStatement.setString(2, password);

                  resultSet = preparedStatement.executeQuery(); // resultSet la 1 tap cac bo sau khi da thuc hien truy van

                  if (!resultSet.next()) {
                      infoBox("Please enter correct Email and Password", null, "Failed");
                  } else {
                   //   infoBox("Login Successfull", null, "Success");

                      info = resultSet.getString("name"); // lay ten cua gia tri tuong ung o cot name
                      profession = resultSet.getString("profession"); //lay ra gia tri tuong ung o cot profession
                      System.out.println(info);
                      Node node = (Node) event.getSource();
                     dialogStage = (Stage) node.getScene().getWindow();
                     dialogStage.close();

              switch (profession) {
                  case "teacher": //case teacher thi goi stage cua teacher

                      loadStage("/home/fxml/TeacherDashboard.fxml");
                      break;
                  default: //case student thi goi state cua student
                      loadStage("/home/fxml/DashBoard.fxml");

                      break;
              }
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }


    }

     //Ham dua ra loi nhac nho
    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }
    //Ham load san khau
    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
           stage.getIcons().add(new Image("/home/image/icon.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // tra lai ten cua id tuong ung

   public static String getInfo(){
        return info;
   }

}
