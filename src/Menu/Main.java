package Menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

//This is  the main class which runs all the other classes and methods in this program
public class Main extends Application {

    public Button Out;
    public Button In;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Menu/Main.fxml"));
        primaryStage.setTitle("Computer Consultancy Firm");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
    }

    public void Out(ActionEvent actionEvent) {

        Alert box = new Alert(Alert.AlertType.CONFIRMATION);
        box.setTitle("Confirmation");
        box.setHeaderText("You're about to Exit");
        box.setContentText("Do you really want to exit?");

        Optional<ButtonType> action = box.showAndWait();
        if (action.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    //This method is used to Navigate to the Login page
    public void In(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Authentication/login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}