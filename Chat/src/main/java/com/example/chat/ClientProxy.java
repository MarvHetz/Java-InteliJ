package com.example.chat;

import java.io.*;
import java.net.Socket;

public class ClientProxy
{
    private final Server server;
    private Socket client;
    private Thread clientThread;

    public ClientProxy(Socket client, Server server)
    {
        this.client = client;
        this.server = server;
        clientThread = new Thread(() -> communicateWithClient());
        clientThread.start();
    }

    private void communicateWithClient()
    {
        try
        {

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;

            while((s = reader.readLine()) != null)
            {
                server.send(s);
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void send(String message)
    {
        try
        {
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            writer.write(message + "\n");
            writer.flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}