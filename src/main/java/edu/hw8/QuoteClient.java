package edu.hw8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuoteClient {

    private QuoteClient() {

    }

    private final static Logger LOGGER = LogManager.getLogger();
    private final static int PORT = 8080;

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";

        try (Socket socket = new Socket(SERVER_IP, PORT);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                LOGGER.info("Ваня: ");
                String request = scanner.nextLine();

                outputStream.write(request.getBytes());
                outputStream.flush();

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);

                if (bytesRead != -1) {
                    String response = new String(buffer, 0, bytesRead);
                    LOGGER.info("Сервер: " + response);
                }
            }

        } catch (IOException e) {
            LOGGER.error("Ошибка!", e);
        }
    }
}
