package Customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerMenu {
    public Button deleteCustomer;
    public Button addCustomer;
    public Button viewCustomer;
    public Button updateCustomer;
    public Button back;
    public Button logout;

    //This method will navigate to the customer delete Page
    public void deleteCustomer(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerDelete.fxml").openStream());
        primaryStage.setTitle("Delete Customer");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the customer add Page
    public void addCustomer(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerAdd.fxml").openStream());
        primaryStage.setTitle("Add Customer");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the customer view Page
    public void viewCustomer(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerView.fxml").openStream());
        primaryStage.setTitle("View Customer");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the customer Update Page
    public void updateCustomer(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerUpdate.fxml").openStream());
        primaryStage.setTitle("Update Customer");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Previous Page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Menu/Menu.fxml").openStream());
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Login Page
    public void logout(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Authentication/Login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
