package com.example.chat;

import com.example.chat.MessageTypes.ReceivedByClient;
import com.example.chat.MessageTypes.ReceivedByServer;
import com.example.chat.MessageTypes.TextMessage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.Socket;
import java.net.URL;
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
	ObjectOutputStream out;

	@FXML
	private void sendMessage()
	{
		try
		{
			out.writeObject(new TextMessage(txtMessage.getText(), ApplicationClient.getName()));
			txtMessage.clear();
			out.reset();
		}catch (IOException e)
		{
			System.out.println("Fehler beim Senden");
		}

	}

	private void sendMessage(Message o)
	{
		try
		{
			out.writeObject(o);
			out.reset();
		}catch (IOException e)
		{
			System.out.println("Fehler beim Senden");
		}
	}

	private void checkForMessages()
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());

			Message o;

			while((o =(Message) in.readObject()) != null)
			{

				System.out.println(o.getType());
				if (o.getType() == TextMessage.class)
				{
					TextMessage textMessage = (TextMessage) o;
					Platform.runLater(() -> listChat.getItems().add(textMessage));
					sendMessage(new ReceivedByClient(ApplicationClient.getName()));
				}
				else if(o.getType() == ReceivedByClient.class)
				{
					System.out.println("ReceivedByClient: "+((ReceivedByClient) o).getName());
				}
				else if (o.getType() == ReceivedByServer.class)
				{
					System.out.println("ReceivedByServer");
				}
				else
				{
					System.out.println("Unbekannter Typ");
				}
			}
		}
		catch (Exception e)
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
			out = new ObjectOutputStream(client.getOutputStream());
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