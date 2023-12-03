package edu.hw8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuoteServer {

    private QuoteServer() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        final int PORT = 8080;
        final int MAX_CONNECTIONS = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            LOGGER.info("Сервер запущен. Ожидание подключений...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                LOGGER.info("Подключился новый клиент.");

                executorService.submit(() -> handleClient(clientSocket));
            }
        } catch (IOException e) {
            LOGGER.error("Ошибка!", e);
        } finally {
            executorService.shutdown();
        }
    }

    @SuppressWarnings("MagicNumber")
    private static void handleClient(Socket clientSocket) {
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String request = new String(buffer, 0, bytesRead);
                String response = getResponse(request);

                outputStream.write(response.getBytes());
                outputStream.flush();
            }

        } catch (IOException e) {
            LOGGER.error("Ошибка! ", e);
        }
    }

    private static String getResponse(String request) {
        return switch (request.toLowerCase()) {
            case "личности" -> "Не переходи на личности там, где их нет";
            case "оскорбления" ->
                "Если твои противники перешли на личные оскорбления, будь уверен — твоя победа не за горами";
            case "глупый" ->
                "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.";
            case "интеллект" -> "Чем ниже интеллект, тем громче оскорбления";
            default -> "Не понял запроса. Попробуй еще раз.";
        };
    }
}
