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

public class CustomerDelete {
    public Button back;
    public TextField textField;
    public Button delete;
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

    //This method is used to delete Customer Details from the Database
    public void delete(ActionEvent actionEvent) throws SQLException {
        boolean checker = false;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            Integer.parseInt(textField.getText());
        } catch (Exception e) {
            checker = true;
        }

        if (textField.getText() == null || textField.getText().trim().isEmpty()) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText("Oops, there was an unfilled information!");
            box.setContentText("Please Fill the Form");
            box.showAndWait();
        } else if (checker) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText(null);
            box.setContentText("Please Fill the Form Correctly. Customer ID Should be consist of numerical character");
            box.showAndWait();
        } else {
            Alert box = new Alert(Alert.AlertType.CONFIRMATION);
            box.setTitle("Confirmation");
            box.setHeaderText("You're about to Delete this Data in the Database.");
            box.setContentText("Do you want to Execute?");

            Optional<ButtonType> action = box.showAndWait();
            if (action.get() == ButtonType.OK) {
                String sql = "DELETE FROM customer WHERE customerID = '" + textField.getText() + "'";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            } else {

            }
        }
    }

    //This method is used to reset the page to its original state
    public void reset(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Customer/CustomerDelete.fxml").openStream());
        primaryStage.setTitle("Delete Customer");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
