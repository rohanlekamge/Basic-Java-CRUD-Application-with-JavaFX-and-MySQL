package Contract;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ContractViewMenu {

    public Button back;
    public Button All;
    public Button logout;

    //This method is used to Navigate to the previous page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractMenu.fxml").openStream());
        primaryStage.setTitle("Contract Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to Navigate to the Table View page
    public void All(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractView.fxml").openStream());
        primaryStage.setTitle("Contract View");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to Navigate to the login page
    public void logout(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Authentication/Login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
