package com.aluraconverter.controller;

import com.aluraconverter.model.ConversorDivisas;
import com.aluraconverter.model.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import javafx.stage.Stage;

/**
 * @version 1.0
 *
 * @author Luis Fernando Garcia
 */

public class MainController {
    @FXML
    private ImageView btn1;
    @FXML
    private ImageView btn2;
    @FXML
    private ImageView btn3;
    @FXML
    private ImageView btn4;
    @FXML
    private Label labelTemp;
    @FXML
    private Label labelDivisa;
    private Stage stage;


    public void btnCambio(MouseEvent mouseEvent) {
        btn1.setVisible(false);
        btn2.setVisible(true);
        labelTemp.setTextFill(Paint.valueOf("#E5E5E5"));
    }

    public void btnCambio2(MouseEvent mouseEvent) {
        btn2.setVisible(false);
        btn1.setVisible(true);
        labelTemp.setTextFill(Paint.valueOf("#FFFFFF"));
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/aluraconverter/view/conversorTemperatura-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/com/aluraconverter/view/style.css").toExternalForm());
            stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("Conversor de Temperatura");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnCambio3(MouseEvent mouseEvent) {
        btn3.setVisible(false);
        btn4.setVisible(true);
        labelDivisa.setTextFill(Paint.valueOf("#E5E5E5"));
    }

    public void btnCambio4(MouseEvent mouseEvent) {
        btn4.setVisible(false);
        btn3.setVisible(true);
        labelDivisa.setTextFill(Paint.valueOf("#FFFFFF"));
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ConversorDivisas.class.getResource("/com/aluraconverter/view/conversorDivisas-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/com/aluraconverter/view/style.css").toExternalForm());
            stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("Conversor de Divisas");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
