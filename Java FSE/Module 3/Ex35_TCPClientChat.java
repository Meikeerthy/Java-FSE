import java.io.*;
import java.net.*;

public class Ex35_TCPClientChat {
    public static void main(String[] args) {
        final String SERVER = "localhost";
        final int PORT = 12345;

        try (Socket socket = new Socket(SERVER, PORT)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                String serverMsg;
                try {
                    while ((serverMsg = in.readLine()) != null) {
                        System.out.println(serverMsg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            }).start();

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            while ((msg = console.readLine()) != null) {
                out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
