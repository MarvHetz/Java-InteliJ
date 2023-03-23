package com.example.chat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationClient extends javafx.application.Application
{
	public static String getName() {
		return name;
	}

	public static void setName(String newName) {
		name = newName;
	}

	private static String name;
	private static Stage stage;

	public static void switchScene() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(ApplicationClient.class.getResource("ChatClientView.fxml"));
		Scene scene = new Scene(fxmlLoader.load(),600,400);
		stage.setTitle(name);
		stage.setScene(scene);
	}

	@Override
	public void start(Stage stage) throws IOException
	{
		this.stage = stage;
		FXMLLoader fxmlLoader = new FXMLLoader(ApplicationClient.class.getResource("NameView.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 600, 400);
		this.stage.setTitle("Nameneingabe");
		this.stage.setScene(scene);
		this.stage.show();
	}

	public static void main(String[] args)
	{
		launch();
	}
}