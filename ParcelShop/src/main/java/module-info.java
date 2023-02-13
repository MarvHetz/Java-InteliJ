module com.example.parcelshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parcelshop to javafx.fxml;
    exports com.example.parcelshop;
}