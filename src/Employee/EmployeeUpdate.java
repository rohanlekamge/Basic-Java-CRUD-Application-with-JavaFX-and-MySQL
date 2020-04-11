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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;

public class EmployeeUpdate {
    public Button back;
    public Button update;
    public DatePicker date;
    public CheckBox SI;
    public CheckBox HT;
    public CheckBox P;
    public TextField textField2;
    public TextField textField1;
    public TextField textField3;
    public Button reset;

    //This method is used to Navigate to the previous page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeMenu.fxml").openStream());
        primaryStage.setTitle("Employee Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to update employee Details in the Database
    public void update(ActionEvent actionEvent) throws SQLException {
        boolean checker = false;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        LocalDate date = this.date.getValue();
        String r1 = "Hardware Technician", r2 = "Programmer", r3 = "Software Installer";

        try {
            Integer.parseInt(textField1.getText());
            Integer.parseInt(textField3.getText());
        } catch (Exception e) {
            checker = true;
        }

        if (textField1.getText() == null || textField1.getText().trim().isEmpty() || textField2.getText() == null || textField2.getText().trim().isEmpty() || textField3.getText() == null || textField3.getText().trim().isEmpty() || this.date.getValue() == null) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText("Oops, there was an unfilled information!");
            box.setContentText("Please Fill the Form");
            box.showAndWait();
        } else if (textField3.getText().length() != 10) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText(null);
            box.setContentText("Please Fill the Form Correctly. Contact Number Should be 10 characters long");
            box.showAndWait();
        } else if (checker) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText(null);
            box.setContentText("Please Fill the Form Correctly. Employee ID and Contact Number Should be consist of numerical characters");
            box.showAndWait();
        } else {
            Alert box = new Alert(Alert.AlertType.CONFIRMATION);
            box.setTitle("Confirmation");
            box.setHeaderText("You're about to Update this Data in the Database.");
            box.setContentText("Do you want to Execute?");

            Optional<ButtonType> action = box.showAndWait();
            if (action.get() == ButtonType.OK) {
                if (HT.isSelected() && P.isSelected() && SI.isSelected()) {
                    if (HT.isSelected()) {
                        String sql1 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r1 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql1);
                    }
                    if (P.isSelected()) {
                        String sql2 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r2 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql2);
                    }
                    if (SI.isSelected()) {
                        String sql3 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r3 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql3);
                    }
                }

                if (HT.isSelected() && P.isSelected()) {
                    if (HT.isSelected()) {
                        String sql1 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r1 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql1);
                    }
                    if (P.isSelected()) {
                        String sql2 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r2 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql2);
                    }
                } else if (HT.isSelected() && SI.isSelected()) {
                    if (HT.isSelected()) {
                        String sql1 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r1 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql1);
                    }
                    if (P.isSelected()) {
                        String sql2 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r3 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql2);
                    }
                } else if (SI.isSelected() && P.isSelected()) {
                    if (HT.isSelected()) {
                        String sql1 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r3 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql1);
                    }
                    if (P.isSelected()) {
                        String sql2 = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r2 + "' WHERE employeeID = '" + textField1.getText() + "'";
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(sql2);
                    }
                } else if (HT.isSelected()) {
                    String sql = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r1 + "' WHERE employeeID = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                } else if (P.isSelected()) {
                    String sql = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r2 + "' WHERE employeeID = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                } else if (SI.isSelected()) {
                    String sql = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + r3 + "' WHERE employeeID = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                } else {
                    String sql = "UPDATE employee SET employeeID = '" + textField1.getText() + "', employeeName = '" + textField2.getText() + "', employeeDOB = '" + date + "', employeeContactNumber = '" + textField3.getText() + "', roleDescription = '" + "" + "' WHERE employeeID = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                }
            } else {

            }
        }
    }

    //This method is used to reset the page to its original state
    public void reset(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Employee/EmployeeUpdate.fxml").openStream());
        primaryStage.setTitle("Update Employee");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
