package com.aluraconverter.controller;

import com.aluraconverter.model.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @version 1.0
 *
 * @author Luis Fernando Garcia
 */
public class ConversorTemperaturaController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBoxTemperature1;
    @FXML
    private ChoiceBox<String> choiceBoxTemperature2;
    @FXML
    private TextField txtValor1;
    @FXML
    private TextField txtValor2;
    @FXML
    private ImageView imgFlag1;
    @FXML
    private ImageView imgFlag2;
    private final String[] divisas = {"°C - celsius", "°F - fahrenheit", "°K - kelvin"};

    @FXML
    public void convertirTemp(ActionEvent actionEvent) {
        try {
            String currency1 = choiceBoxTemperature1.getValue().substring(1, 2);
            String currency2 = choiceBoxTemperature2.getValue().substring(1, 2);
            float valor1 = Float.parseFloat(txtValor1.getText());
            float resultado;
            switch (currency1) {
                case "C" -> resultado = switch (currency2) {
                    case "C" -> valor1;
                    case "F" -> (float) (1.8 * valor1 + 32);
                    case "K" -> (float) (valor1 + 273.15);
                    default -> throw new NullPointerException();
                };
                case "F" -> resultado = switch (currency2) {
                    case "C" -> (float) ((valor1 - 32) / 1.8);
                    case "F" -> valor1;
                    case "K" -> (float) ((valor1 - 32) / 1.8 + 273.15);
                    default -> throw new NullPointerException();
                };
                case "K" -> resultado = switch (currency2) {
                    case "C" -> (float) (valor1 - 273.15);
                    case "F" -> (float) ((valor1 - 273.15) * 1.8 + 32);
                    case "K" -> valor1;
                    default -> throw new NullPointerException();
                };
                default -> throw new NullPointerException();
            }
            txtValor2.setText(String.valueOf(resultado));
        }catch (NullPointerException nullPointerException){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Seleccione las unidades de temperatura que quiere converir");
            alert.showAndWait();
        }catch (NumberFormatException numberFormatException){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("valor ingresado incorrecto, favor de ingresar solo numeros y no dejar este campo vacio");
        alert.showAndWait();

    } catch (Exception e){
        e.printStackTrace();


    }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxTemperature1.getItems().addAll(divisas);
        choiceBoxTemperature2.getItems().addAll(divisas);

    }
    @FXML
    public void setFlag1(ActionEvent actionEvent) {
        String val = choiceBoxTemperature1.getValue().substring(1,2);
        System.out.println(val);
        Image image = new Image(new File(".\\src\\main\\resources\\com\\aluraconverter\\img\\" + val + ".jpg").toURI().toString());
        imgFlag1.setImage(image);

    }
    @FXML
    public void setFlag2(ActionEvent actionEvent) {
        String val = choiceBoxTemperature2.getValue().substring(1,2);

        Image image = new Image(new File(".\\src\\main\\resources\\com\\aluraconverter\\img\\" + val + ".jpg").toURI().toString());
        imgFlag2.setImage(image);

    }

    public void backHome(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/aluraconverter/view/main-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/com/aluraconverter/view/style.css").toExternalForm());
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("Conversor Alura");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
