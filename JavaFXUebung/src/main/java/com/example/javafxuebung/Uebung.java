package com.example.javafxuebung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Uebung extends Application
{
    public static Scene getKontoUebersichtScene()
    {
        return kontoUebersichtScene;
    }

    public static Stage getStage()
    {
        return stage;
    }

    private static Stage stage;

    private static Scene kontoUebersichtScene;
    @Override
    public void start(Stage stage) throws IOException
    {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Uebung.class.getResource("Login.fxml"));
        Scene login = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(login);
        stage.show();

        FXMLLoader fxmlLoader1 = new FXMLLoader(Uebung.class.getResource("KontoUebersicht.fxml"));
        kontoUebersichtScene = new Scene(fxmlLoader1.load(), 600, 400);
    }

    public static void main(String[] args)
    {
        launch();
    }
}