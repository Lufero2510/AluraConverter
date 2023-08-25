module com.aluraconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    exports com.aluraconverter.model;
    opens com.aluraconverter.model to javafx.fxml;
    exports com.aluraconverter.controller;
    opens com.aluraconverter.controller to javafx.fxml;
}