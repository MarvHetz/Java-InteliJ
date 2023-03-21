import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server
{
    public static void main(String[] args)
    {
        new Server();
    }
    public Server()
    {
        try
        {
            ServerSocket server = new ServerSocket(8008);
            System.out.println("Server gestartet");

            Socket client = server.accept();

            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;

            while((s = reader.readLine()) != null)
            {
                writer.write(s + "\n");
                writer.flush();
                System.out.println("Empfangen vom Client: " + s);
            }

            writer.close();
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
