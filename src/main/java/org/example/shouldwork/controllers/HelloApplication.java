package org.example.shouldwork.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SuperFit");

        // Load the initial scene (LogIn.fxml)
        showScene("/org/example/shouldwork/dashboard.fxml");
    }

    // Method to switch scenes dynamically
    public void showScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Dynamically invoke setMainApp if the controller has it
            Object controller = loader.getController();
            if (controller != null) {
                try {
                    controller.getClass()
                            .getMethod("setMainApp", HelloApplication.class)
                            .invoke(controller, this);
                } catch (NoSuchMethodException ignored) {
                    // Controller does not have setMainApp, no action needed
                }
            }

            // Display the scene
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException | ReflectiveOperationException e) {
            System.err.println("Failed to load FXML file or set controller: " + fxmlFile);
            e.printStackTrace();
        }
    }



    public static void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(HelloApplication.class.getResource(fxml));
        stage.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
