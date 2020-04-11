package Employee;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class EmployeeSalary {
    public Button reset;
    public Button back;
    public Button display;
    public TextField textField;
    public TextField hours;

    //This method is used to reset the page to its original state
    public void reset(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeSalary.fxml").openStream());
        primaryStage.setTitle("Employee Salary");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to Navigate to the previous page
    public void back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeMenu.fxml").openStream());
        primaryStage.setTitle("Employee Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //displays the calculated salary
    public void display(ActionEvent event) throws SQLException {
        boolean checker = false;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            Integer.parseInt(textField.getText());
            Integer.parseInt(hours.getText());
        } catch (Exception e) {
            checker = true;
        }

        if (textField.getText() == null || textField.getText().trim().isEmpty() || hours.getText() == null || hours.getText().trim().isEmpty()) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText("Oops, there was an unfilled information!");
            box.setContentText("Please Fill the Form");
            box.showAndWait();
        } else if (checker) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText(null);
            box.setContentText("Please Fill the Form Correctly. Employee ID and Working Hours Should be consist of numerical character");
            box.showAndWait();
        } else {
            Alert box = new Alert(Alert.AlertType.CONFIRMATION);
            box.setTitle("Confirmation");
            box.setHeaderText("You're about to Calculate the Monthly Salary of an Employee.");
            box.setContentText("Do you want to Execute?");

            Optional<ButtonType> action = box.showAndWait();
            if (action.get() == ButtonType.OK) {
                String sql1 = "SELECT * FROM employee WHERE employeeID = '" + textField.getText() + "'";

                Statement statement = connection.createStatement();
                int salary = 0;
                String output = null;
                ResultSet rs = statement.executeQuery(sql1);

                while (rs.next()) {
                    String roleDescription = rs.getString("roleDescription");

                    if (roleDescription.equals("Programmer")) {
                        salary += Integer.parseInt(hours.getText()) / 6 * 3 * 150;
                    }
                    if (roleDescription.equals("Hardware Technician")) {
                        salary += Integer.parseInt(hours.getText()) / 6 * 2 * 100;
                    }
                    if (roleDescription.equals("Software Installer")) {
                        salary += Integer.parseInt(hours.getText()) / 6 * 50;
                    }
                    output = Integer.toString(salary);
                }

                Alert box1 = new Alert(Alert.AlertType.INFORMATION);
                box1.setTitle("Monthly Payroll");
                box1.setHeaderText(null);
                box1.setContentText("Monthly Payroll is:  Rs." + output);
                box1.showAndWait();

            } else {

            }
        }
    }
}
