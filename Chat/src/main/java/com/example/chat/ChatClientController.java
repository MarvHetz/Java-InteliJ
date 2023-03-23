package com.example.chat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.URL;
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
	private ObservableList<String> chat;

	@FXML
	private void sendMessage()
	{
		try
		{
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.write(txtMessage.getText() + "\n");
			writer.flush();
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
				Platform.runLater(() -> chat.add(message));
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
		chat = FXCollections.observableArrayList();
		listChat.setItems(chat);
		try
		{
			client = new Socket("localhost", 8006);
			System.out.println("Client gestartet");
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		new Thread(() -> checkForMessages()).start();
	}
}