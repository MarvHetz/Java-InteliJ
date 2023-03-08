module com.volumenrechner {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.volumenrechner to javafx.fxml;
    exports com.volumenrechner;
}