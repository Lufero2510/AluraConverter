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

public class ConversorTemperatura extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage secondStage) throws Exception {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(ConversorDivisas.class.getResource("conversorDivisas-view.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(ConversorTemperatura.class.getResource("/com/aluraconverter/view/conversorTemperatura-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/com/aluraconverter/view/style.css").toExternalForm());
            secondStage.setTitle("Conversor de Temperatura");
            secondStage.setScene(scene);
            secondStage.setResizable(false);
            secondStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
