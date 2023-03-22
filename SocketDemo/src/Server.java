import javax.print.attribute.standard.RequestingUserName;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;

public class Server
{
    private ArrayList<ClientProxy> clients;
    public static void main(String[] args)
    {
        new Server();
    }
    public Server()
    {
        clients = new ArrayList<>();
        new Thread(() -> {for (int i = 0; i < 2; i++)newServerSocket();}).start();
    }

    public void newServerSocket()
    {
        try
        {
            ServerSocket server = new ServerSocket(8006);
            System.out.println("Server gestartet");

            Socket client = server.accept();
            server.close();

            clients.add(new ClientProxy(client,this));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
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
