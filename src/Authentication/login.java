package Authentication;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login {
    public TextField userName;
    public PasswordField userPassword;
    public Label isConnected;
    public Button back;

    public void login(ActionEvent actionEvent) throws IOException {
        //Establish the connection between database and the Java program using JDBC
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            //Connect with the database if the entered username and Password matches the currently given password and Username.
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM userauthentication WHERE userName = '" + userName.getText() + "' AND userPassword = '" + userPassword.getText() + "';";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                ((Node) actionEvent.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("../Menu/Menu.fxml").openStream());
                primaryStage.setTitle("Menu");
                primaryStage.setScene(new Scene(root, 596, 568));
                primaryStage.show();
            } else {
                isConnected.setText("Username and Password is not correct");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //This method is used to Navigate to the previous page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Menu/Main.fxml").openStream());
        primaryStage.setTitle("Computer Consultancy Firm");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}