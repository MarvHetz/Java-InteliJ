package com.example.chat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationClient extends javafx.application.Application
{
	@Override
	public void start(Stage stage) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(ApplicationClient.class.getResource("ChatClientView.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 600, 400);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch();
	}
}