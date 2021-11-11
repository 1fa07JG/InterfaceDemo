module com.example.interfacedemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.interfacedemo to javafx.fxml;
    exports com.example.interfacedemo;
}