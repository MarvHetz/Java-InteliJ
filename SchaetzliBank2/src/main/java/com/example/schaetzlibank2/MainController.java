package com.example.schaetzlibank2;

import javafx.stage.Stage;
import java.io.IOException;

public class MainController
{
    public static DBController getDbController()
    {
        return dbController;
    }

    private static DBController dbController;
    public static Stage getStage()
    {
        return stage;
    }
    private static Stage stage;
    private static LoginController loginController;

    public MainController(Stage stage) throws IOException
    {
        this.stage = stage;
        loginController = new LoginController();
        dbController = new DBController();
    }
}
