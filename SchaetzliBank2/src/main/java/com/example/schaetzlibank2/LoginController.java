package com.example.schaetzlibank2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoginController
{
    @FXML
    private static Button btnLogin;
    private static Scene scene;
    public LoginController() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);
        MainController.getStage().setTitle("Login");
        fxmlLoader.setController(this);
        MainController.getStage().setScene(scene);
        MainController.getStage().show();


        btnLogin.setOnAction(e -> MainController.getDbController().checkLogin());
    }
}