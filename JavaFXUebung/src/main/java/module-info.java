module com.example.javafxuebung {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxuebung to javafx.fxml;
    exports com.example.javafxuebung;
}