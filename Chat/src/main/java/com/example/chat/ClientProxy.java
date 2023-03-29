package com.example.chat;

import com.example.chat.MessageTypes.ReceivedByClient;
import com.example.chat.MessageTypes.ReceivedByServer;
import com.example.chat.MessageTypes.TextMessage;

import java.io.*;
import java.net.Socket;

public class ClientProxy
{
    private final Server server;
    private Socket client;
    private Thread clientThread;
    private ObjectOutputStream out;

    public ClientProxy(Socket client, Server server) throws IOException
    {
        this.client = client;
        this.server = server;
        out = new ObjectOutputStream(client.getOutputStream());
        clientThread = new Thread(() -> communicateWithClient());
        clientThread.start();
    }

    private void communicateWithClient()
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
                    send(new ReceivedByServer());
                    server.send(textMessage,this);
                }
                else if(o.getType() == ReceivedByClient.class)
                {
                    server.getCurrentSender().send(o);
                }
            }
            in.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void send(Message o)
    {
        new Thread(() -> {
            try
            {
                out.writeObject(o);
                out.reset();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }).start();
    }
}