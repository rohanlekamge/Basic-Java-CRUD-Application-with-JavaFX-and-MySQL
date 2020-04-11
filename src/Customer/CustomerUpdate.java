package Customer;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class CustomerUpdate {
    public Button back;
    public Button update;
    public TextField textField4;
    public TextField textField3;
    public TextField textField2;
    public TextField textField1;
    public Button logout;

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

    //This method is used to update customer Details in the Database
    public void update(ActionEvent actionEvent) throws SQLException {
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
            Alert box = new Alert(Alert.AlertType.CONFIRMATION);
            box.setTitle("Confirmation");
            box.setHeaderText("You're about to Update this Data in the Database.");
            box.setContentText("Do you want to Execute?");

            Optional<ButtonType> action = box.showAndWait();
            if (action.get() == ButtonType.OK) {
                String sql = "UPDATE customer SET customerID = '" + textField1.getText() + "', customerName = '" + textField2.getText() + "', customerContactNumber = '" + textField3.getText() + "', customerAddress = '" + textField4.getText() + "' WHERE customerID = '" + textField1.getText() + "'";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            } else {

            }
        }
    }

    //This method is used to reset the page to its original state
    public void logout(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerUpdate.fxml").openStream());
        primaryStage.setTitle("Update Customer");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
