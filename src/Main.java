import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {  // Skapa socket
            System.out.println("Server startad på port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Vänta på anslutning
                System.out.println("Ny anslutning från " + clientSocket.getInetAddress());

                // Skicka hello world
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // HTTP Response
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain");
                out.println();
                out.println("Hello World!");

                clientSocket.close(); // Stäng anslutningen
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
