package com.example.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class Server
{
	private static ArrayList<ClientProxy> clients;
	public static void main(String[] args)
	{
		new Server();
	}

	public Server()
	{
		System.out.println("Server gestartet");
		clients = new ArrayList<>();
		//for (int i = 0; i < 3; i++)
		while(true)
		{
			try
			{
				ServerSocket server = new ServerSocket(8006);
				Socket client = server.accept();
				System.out.println(client);
				server.close();

				clients.add(new ClientProxy(client, this));
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
	}

	public void send(String message)
	{
		new Thread(() -> {
			for (ClientProxy client : clients)
			{
				client.send(message);
			}}).start();
	}

}
