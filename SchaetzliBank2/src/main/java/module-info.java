module com.example.schaetzlibank2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.schaetzlibank2 to javafx.fxml;
    exports com.example.schaetzlibank2;
}