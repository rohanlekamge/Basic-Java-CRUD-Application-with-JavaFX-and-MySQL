package Customer;

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
import java.util.Optional;

public class CustomerAdd {
    public Button back;
    public Label label;
    public Button add;
    public TextField textField1;
    public TextField textField2;
    public TextField textField3;
    public TextField textField4;
    public Button reset;

    //This method is used to Navigate to the previous page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerMenu.fxml").openStream());
        primaryStage.setTitle("Customer Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to add Customer Details to the Database
    public void add(ActionEvent actionEvent) throws SQLException {
        boolean checker = false;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            Integer.parseInt(textField1.getText());
            Integer.parseInt(textField3.getText());
        } catch (Exception e) {
            checker = true;
        }

        if (textField1.getText() == null || textField1.getText().trim().isEmpty() || textField2.getText() == null || textField2.getText().trim().isEmpty() || textField3.getText() == null || textField3.getText().trim().isEmpty() || textField4.getText() == null || textField4.getText().trim().isEmpty()) {
            //Shows Error Type alert box. Validate if there is any unfilled information
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
            box.setContentText("Please Fill the Form Correctly. Customer ID and Contact Number Should be consist of numerical characters");
            box.showAndWait();
        } else {
            //this is the validation part which uses to show pop up box when you're about hit enter after filling the all fields
            Alert box = new Alert(Alert.AlertType.CONFIRMATION);
            box.setTitle("Confirmation");
            box.setHeaderText("You're about to Add this Data in to the Database.");
            box.setContentText("Do you want to Execute?");

            Optional<ButtonType> action = box.showAndWait();
            if (action.get() == ButtonType.OK) {
                String sql = "INSERT INTO customer (customerID, customerName, customerContactNumber, customerAddress) VALUES('" + textField1.getText() + "' , '" + textField2.getText() + "' , '" + textField3.getText() + "' , '" + textField4.getText() + "')";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            }
        }
    }

    public void reset(ActionEvent event) throws IOException {
        //This method is used to reset the page to its original state
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerAdd.fxml").openStream());
        primaryStage.setTitle("Add Customer");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}