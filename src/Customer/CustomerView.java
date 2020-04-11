package Customer;

import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerView implements Initializable {
    public Button back;
    public Button logout;

    @FXML
    private TableView<ModelTable1> table;
    @FXML
    private TableColumn<ModelTable1, String> ID;
    @FXML
    private TableColumn<ModelTable1, String> Name;
    @FXML
    private TableColumn<ModelTable1, String> ContactNumber;
    @FXML
    private TableColumn<ModelTable1, String> Address;

    //Declaring an ArrayList
    ObservableList<ModelTable1> ArrayList = FXCollections.observableArrayList();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customer");

            while (rs.next()) {
                ArrayList.add(new ModelTable1(rs.getString("customerID"), rs.getString("customerName"), rs.getString("customerContactNumber"), rs.getString("customerAddress")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.setItems(ArrayList);

        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        ContactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));

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
