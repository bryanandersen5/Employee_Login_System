package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class DBUtils {

    public static void changeScene(ActionEvent event, String fxmlFile, String title, Integer empID) {
        Parent root = null;

        if (empID != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setEmployeeInformation(empID);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //get clicked-> get scene -> get window (double cast)
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    public static void logInEmp(ActionEvent event, Integer EmpID, String Password){
        Connection connection = null;
        PreparedStatement preparedStatement = null; //query
        ResultSet resultSet = null; //data return
        try{
            connection = DriverManager.getConnection("");
            preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE emp_id = ");
            preparedStatement.setInt(1,EmpID);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()) {
                System.out.println("Employee not found.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are not correct.");
                alert.show();
            } else{
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(Password)) {
                        changeScene(event,"logged-in","Welcome",EmpID);
                    } else {
                        System.out.println("Passwords did not match.");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are not correct.");
                        alert.show();
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
