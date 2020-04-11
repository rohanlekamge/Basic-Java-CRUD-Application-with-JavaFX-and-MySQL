package Contract;

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

public class ContractView implements Initializable {
    public Button back;
    public Button logout;

    @FXML
    private TableView<ModelTable3> table;
    @FXML
    private TableColumn<ModelTable3, String> coID;
    @FXML
    private TableColumn<ModelTable3, String> emID;
    @FXML
    private TableColumn<ModelTable3, String> cuID;
    @FXML
    private TableColumn<ModelTable3, String> Description;
    @FXML
    private TableColumn<ModelTable3, String> Date;
    @FXML
    private TableColumn<ModelTable3, String> JobType;

    //Declaring an ArrayList
    ObservableList<ModelTable3> ArrayList = FXCollections.observableArrayList();

    //This method is used to Navigate to the previous page
    public void back(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("../Contract/ContractViewMenu.fxml").openStream());
        primaryStage.setTitle("Contract View Menu");
        primaryStage.setScene(new Scene(root, 596, 568));
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();

            ResultSet rs = connection .createStatement().executeQuery("SELECT * FROM contract");

            while (rs.next()){
                ArrayList.add(new ModelTable3(rs.getString("contractID"), rs.getString("employeeID"), rs.getString("customerID"), rs.getString("contractDescription"), rs.getString("creationDate"), rs.getString("jobType") ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.setItems(ArrayList);

        coID.setCellValueFactory(new PropertyValueFactory<>("coid"));
        emID.setCellValueFactory(new PropertyValueFactory<>("emid"));
        cuID.setCellValueFactory(new PropertyValueFactory<>("cuid"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        JobType.setCellValueFactory(new PropertyValueFactory<>("jobtype"));

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
