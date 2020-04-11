package Contract;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ContractMenu {
    public Button addContract;
    public Button deleteContract;
    public Button updateContract;
    public Button viewContract;
    public Button back;
    public Button logout;

    //This method will navigate to the Contract Update Page
    public void updateContract(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractUpdate.fxml").openStream());
        primaryStage.setTitle("Update Contract");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Contract View Page
    public void viewContract(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractViewMenu.fxml").openStream());
        primaryStage.setTitle("View Contract");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Contract Add Page
    public void addContract(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractAdd.fxml").openStream());
        primaryStage.setTitle("Add Contract");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Contract Delete Page
    public void deleteContract(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractDelete.fxml").openStream());
        primaryStage.setTitle("Delete Contract");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Previous Page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Menu/Menu.fxml").openStream());
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Login Page
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
