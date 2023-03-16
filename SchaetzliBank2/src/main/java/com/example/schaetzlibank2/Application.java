package com.example.schaetzlibank2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        new MainController(stage);
    }

    public static void main(String[] args)
    {
        launch();
    }
}