package com.aluraconverter.controller;

import com.aluraconverter.model.ConexionApi;
import com.aluraconverter.model.Conversion;
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
import org.json.JSONObject;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @version 1.0
 *
 * @author Luis Fernando Garcia
 */

public class ConversorDivisasController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBoxDivisa1;
    @FXML
    private ChoiceBox<String> choiceBoxDivisa2;
    @FXML
    private TextField txtValor1;
    @FXML
    private TextField txtValor2;
    @FXML
    private ImageView imgFlag1;
    @FXML
    private ImageView imgFlag2;
    private final String[] divisas = {"MXN $ - Peso mexicano", "USD $ - Dólar estadounidense", "EUR € - Euro", "CAD $ - Dólar canadiense","JPY ¥ - Yen japonés", "CNY ¥ - Yuan chino", "KRW ₩ - Won surcoreano","RUB ₽ - Rublo ruso"};


    @FXML
    public void convertirDivisa(ActionEvent actionEvent) {
        //solicitar una peticion
        try {
            String currency1 = choiceBoxDivisa1.getValue().substring(0,3);
            String currency2 = choiceBoxDivisa2.getValue().substring(0,3);
            float valor1 = Float.parseFloat(txtValor1.getText());

            ConexionApi conexionApi = new ConexionApi("http://api.exchangeratesapi.io/latest?symbols="+currency1+","+currency2+"&access_key=12eba3460bbbbe024b07f119047e9c06");
            conexionApi.conexion();
            int responseCode = conexionApi.getResponseCode();
            System.out.println(responseCode);
            if (responseCode != 200){
                throw new RuntimeException("Ocurrio un error: " + responseCode);
            }else{
                JSONObject jsonObject = conexionApi.getJson();
                JSONObject ratesObject = jsonObject.getJSONObject("rates");
                float moneda1 = ratesObject.getFloat(currency1);
                float moneda2 = ratesObject.getFloat(currency2);
                Conversion conversion = new Conversion(moneda1, moneda2, valor1);

                float resultado = conversion.conversion();
                txtValor2.setText(String.valueOf(resultado));

                System.out.println(ratesObject);

            }

        } catch (NullPointerException nullPointerException){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Seleccione las divisas que quiere converir");
            alert.showAndWait();
        } catch (NumberFormatException numberFormatException){
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
        choiceBoxDivisa1.getItems().addAll(divisas);
        choiceBoxDivisa2.getItems().addAll(divisas);

    }
    @FXML
    public void setFlag1(ActionEvent actionEvent) {
        String currency = choiceBoxDivisa1.getValue().substring(0,3);

        Image image = new Image(new File(".\\src\\main\\resources\\com\\aluraconverter\\img\\" + currency + ".jpg").toURI().toString());
        imgFlag1.setImage(image);

    }
    @FXML
    public void setFlag2(ActionEvent actionEvent) {
        String currency = choiceBoxDivisa2.getValue().substring(0,3);

        Image image = new Image(new File(".\\src\\main\\resources\\com\\aluraconverter\\img\\" + currency + ".jpg").toURI().toString());
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
