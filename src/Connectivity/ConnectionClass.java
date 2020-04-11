package Connectivity;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;

    /* This method is used to automatically connect with the database i have already created in the
       MySQL Database. Default Username is "root" and Password field is empty. */
    public Connection getConnection() {
        String dbName = "assignment";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);

        } catch (Exception e) {
            e.printStackTrace();
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setTitle("Confirmation");
            box.setHeaderText(null);
            box.setContentText("Database Connection is not Established. Please Check your Server.");
            box.showAndWait();
        }

        return connection;
    }
}