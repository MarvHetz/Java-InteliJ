package com.example.chat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class ChatClientController implements Initializable
{
	private Socket client;
	@FXML
	private Button btnSend;
	@FXML
	private TextField txtMessage;
	@FXML
	private ListView listChat;

	@FXML
	private void sendMessage()
	{
		try
		{
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.write(ApplicationClient.getName() + ": " + txtMessage.getText() + "\n");
			writer.flush();
			txtMessage.clear();
		}catch (IOException e)
		{
			System.out.println("Fehler beim Senden");
		}

	}

	private void checkForMessages()
	{
		try
		{
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String s = null;
			while((s = reader.readLine()) != null)
			{
				final String message = s;
				Platform.runLater(() -> listChat.getItems().add(message));
			}
			reader.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		try
		{
			client = new Socket("localhost", 8006);
			System.out.println("Client gestartet");
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		settupListView();

		new Thread(() -> checkForMessages()).start();
	}

	private void settupListView()
	{

	}
}