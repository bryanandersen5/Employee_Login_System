package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TEST");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
