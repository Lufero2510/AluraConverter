package com.aluraconverter.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @version 1.0
 *
 * @author Luis Fernando Garcia
 */

public class ConversorDivisas extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(ConversorDivisas.class.getResource("conversorDivisas-view.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(ConversorDivisas.class.getResource("/com/aluraconverter/view/conversorDivisas-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/com/aluraconverter/view/style.css").toExternalForm());
            primaryStage.setTitle("Conversor de Divisas");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
