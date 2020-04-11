package Contract;

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

public class ContractUpdate {
    public Button back;
    public TextField textField1;
    public TextField textField2;
    public Button update;
    public TextArea textField4;
    public DatePicker date;
    public RadioButton radio1;
    public ToggleGroup MyGroup;
    public RadioButton radio2;
    public TextField textField3;
    public Button reset;

    //This method is used to Navigate to the previous page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractMenu.fxml").openStream());
        primaryStage.setTitle("Contract Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    //This method is used to update Contract Details in the Database
    public void update(ActionEvent actionEvent) throws SQLException {
        boolean checker = false;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        LocalDate date = this.date.getValue();

        try {
            Integer.parseInt(textField1.getText());
            Integer.parseInt(textField2.getText());
            Integer.parseInt(textField3.getText());
        } catch (Exception e) {
            checker = true;
        }

        if (textField1.getText() == null || textField1.getText().trim().isEmpty() || textField2.getText() == null || textField2.getText().trim().isEmpty() || textField3.getText() == null || textField3.getText().trim().isEmpty() || textField4.getText() == null || textField4.getText().trim().isEmpty() || this.date.getValue() == null || textField4.getText().trim().isEmpty()) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText("Oops, there was an unfilled information!");
            box.setContentText("Please Fill the Form");
            box.showAndWait();
        } else if (checker) {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText(null);
            box.setContentText("Please Fill the Form Correctly. Customer ID and Contact ID, Employee ID Should be consist of numerical characters");
            box.showAndWait();
        } else {
            Alert box = new Alert(Alert.AlertType.CONFIRMATION);
            box.setTitle("Confirmation");
            box.setHeaderText("You're about to Update this Data in the Database.");
            box.setContentText("Do you want to Execute?");

            Optional<ButtonType> action = box.showAndWait();
            if (action.get() == ButtonType.OK) {
                if (radio1.isSelected()) {
                    String r1 = "System Development";

                    String sql = "UPDATE contract SET creationDate = '" + date + "', contractID = '" + textField1.getText() + "', employeeID = '" + textField2.getText() + "', customerID = '" + textField3.getText() + "', contractDescription = '" + textField4.getText() + "', jobType = '" + r1 + "' WHERE contractID = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                } else if (radio2.isSelected()) {
                    String r2 = "Software Upgrade";
                    String sql = "UPDATE contract SET creationDate = '" + date + "', contractID = '" + textField1.getText() + "', employeeID = '" + textField2.getText() + "', customerID = '" + textField3.getText() + "', contractDescription = '" + textField4.getText() + "', jobType = '" + r2 + "' WHERE contractID = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                }
            }
        }
    }

    //This method is used to reset the page to its original state
    public void reset(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractUpdate.fxml").openStream());
        primaryStage.setTitle("Update Contract");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }
}
