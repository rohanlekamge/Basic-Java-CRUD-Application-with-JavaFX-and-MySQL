package Employee;

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

public class EmployeeMenu implements Initializable {
    public Button deleteEmployee;
    public Button addEmployee;
    public Button viewEmployee;
    public Button updateEmployee;
    public Button back;
    public Button logout;
    public Button salaryEmployee;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //This method will navigate to the employee delete Page
    public void deleteEmployee(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeDelete.fxml").openStream());
        primaryStage.setTitle("Delete Employee");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the employee add Page
    public void addEmployee(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeAdd.fxml").openStream());
        primaryStage.setTitle("Add Employee");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the employee view Page
    public void viewEmployee(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeViewMenu.fxml").openStream());
        primaryStage.setTitle("View Employee Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the employee Update Page
    public void updateEmployee(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeUpdate.fxml").openStream());
        primaryStage.setTitle("Update Employee");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Previous Page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Menu/Menu.fxml").openStream());
        primaryStage.setTitle("Employee Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Login Page
    public void logout(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Authentication/login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method will navigate to the Employee Salary Page
    public void salaryEmployee(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeSalary.fxml").openStream());
        primaryStage.setTitle("Update Employee");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
