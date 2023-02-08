module com.example.fx1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fx1 to javafx.fxml;
    exports com.example.fx1;
}