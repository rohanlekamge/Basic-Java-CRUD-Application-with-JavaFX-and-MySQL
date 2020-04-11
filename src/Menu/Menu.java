package Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    public Button employee;
    public Button customer;
    public Button contract;
    public Button back;
    public Button logout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //This method is used to Navigate to the Employee Menu page
    public void employee(javafx.event.ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeMenu.fxml").openStream());
        primaryStage.setTitle("Employee Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to Navigate to the Customer Menu page
    public void customer(javafx.event.ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerMenu.fxml").openStream());
        primaryStage.setTitle("Customer Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to Navigate to the Contract Menu page
    public void contract(javafx.event.ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractMenu.fxml").openStream());
        primaryStage.setTitle("Contract Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to Navigate to the Previous page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Authentication/login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to Navigate to the Login page
    public void logout(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Authentication/login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
