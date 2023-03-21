import java.io.*;
import java.net.Socket;

public class Client
{
    public static void main(String[] args)
    {
        new Client();
    }

    public Client()
    {
        try
        {
            Socket client = new Socket("172.16.225.2", 8006);
            System.out.println("Client gestartet");

            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            writer.write("Hallo Server\n");
            writer.flush();

            String s = null;

            while((s = reader.readLine()) != null)
            {
                System.out.println("Empfangen vom Server: " + s);
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
