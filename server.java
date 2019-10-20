
import java.net.*;
        import java.io.*;

public class server
{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in	 = null;

    public server(int port)
    {//constructor with port as parameter
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

           // System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted: Hello");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads the message from the client till "Bye" is sent
            while (!line.equals("Bye"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        server server = new server(5000);
    }
}
