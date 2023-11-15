package edu.project3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class Utils {
    private static final int MAX_AMOUNT = 3;

    private static final Map<String, String> HTTP_STATUS_CODE_MAP = new HashMap<>();

    static {
        HTTP_STATUS_CODE_MAP.put("100", "Continue (продолжайте)");
        HTTP_STATUS_CODE_MAP.put("101", "Switching Protocols (переключение протоколов)");
        HTTP_STATUS_CODE_MAP.put("102", "Processing (идёт обработка)");
        HTTP_STATUS_CODE_MAP.put("103", "Early Hints (ранняя метаинформация)");
        HTTP_STATUS_CODE_MAP.put("200", "OK (хорошо)");
        HTTP_STATUS_CODE_MAP.put("201", "Created (создано)");
        HTTP_STATUS_CODE_MAP.put("202", "Accepted (принято)");
        HTTP_STATUS_CODE_MAP.put("203", "Non-Authoritative Information (информация не авторитетна)");
        HTTP_STATUS_CODE_MAP.put("204", "No Content (нет содержимого)");
        HTTP_STATUS_CODE_MAP.put("205", "Reset Content (сбросить содержимое)");
        HTTP_STATUS_CODE_MAP.put("206", "Partial Content (частичное содержимое)");
        HTTP_STATUS_CODE_MAP.put("207", "Multi-Status (многостатусный)");
        HTTP_STATUS_CODE_MAP.put("208", "Already Reported (уже сообщалось)");
        HTTP_STATUS_CODE_MAP.put("226", "IM Used (использовано IM)");
        HTTP_STATUS_CODE_MAP.put("300", "Multiple Choices (множество выборов)");
        HTTP_STATUS_CODE_MAP.put("301", "Moved Permanently (перемещено навсегда)");
        HTTP_STATUS_CODE_MAP.put("302", "Moved Temporarily (перемещено временно)");
        HTTP_STATUS_CODE_MAP.put("303", "See Other (смотреть другое)");
        HTTP_STATUS_CODE_MAP.put("304", "Not Modified (не изменялось)");
        HTTP_STATUS_CODE_MAP.put("305", "Use Proxy (использовать прокси)");
        HTTP_STATUS_CODE_MAP.put("306", "— зарезервировано (код использовался только в ранних спецификациях)");
        HTTP_STATUS_CODE_MAP.put("307", "Temporary Redirect (временное перенаправление)");
        HTTP_STATUS_CODE_MAP.put("308", "Permanent Redirect (постоянное перенаправление)");
        HTTP_STATUS_CODE_MAP.put("400", "Bad Request (неправильный, некорректный запрос)");
        HTTP_STATUS_CODE_MAP.put("401", "Unauthorized (не авторизован (не представился))");
        HTTP_STATUS_CODE_MAP.put("402", "Payment Required (необходима оплата)");
        HTTP_STATUS_CODE_MAP.put("403", "Forbidden (запрещено (не уполномочен))");
        HTTP_STATUS_CODE_MAP.put("404", "Not Found (не найдено)");
        HTTP_STATUS_CODE_MAP.put("405", "Method Not Allowed (метод не поддерживается)");
        HTTP_STATUS_CODE_MAP.put("406", "Not Acceptable (неприемлемо)");
        HTTP_STATUS_CODE_MAP.put("407", "Proxy Authentication Required (необходима аутентификация прокси)");
        HTTP_STATUS_CODE_MAP.put("408", "Request Timeout (истекло время ожидания)");
        HTTP_STATUS_CODE_MAP.put("409", "Conflict (конфликт)");
        HTTP_STATUS_CODE_MAP.put("410", "Gone (удалён)");
        HTTP_STATUS_CODE_MAP.put("411", "Length Required (необходима длина)");
        HTTP_STATUS_CODE_MAP.put("412", "Precondition Failed (условие ложно)");
        HTTP_STATUS_CODE_MAP.put("413", "Payload Too Large (полезная нагрузка слишком велика)");
        HTTP_STATUS_CODE_MAP.put("414", "URI Too Long (URI слишком длинный)");
        HTTP_STATUS_CODE_MAP.put("415", "Unsupported Media Type (неподдерживаемый тип данных)");
        HTTP_STATUS_CODE_MAP.put("416", "Range Not Satisfiable (диапазон не достижим)");
        HTTP_STATUS_CODE_MAP.put("417", "Expectation Failed (ожидание не удалось)");
        HTTP_STATUS_CODE_MAP.put("418", "I’m a teapot (я — чайник)");
        HTTP_STATUS_CODE_MAP.put("419", "Authentication Timeout (not in RFC 2616) (обычно ошибка проверки CSRF)");
        HTTP_STATUS_CODE_MAP.put("421", "Misdirected Request");
        HTTP_STATUS_CODE_MAP.put("422", "Unprocessable Entity (необрабатываемый экземпляр)");
        HTTP_STATUS_CODE_MAP.put("423", "Locked (заблокировано)");
        HTTP_STATUS_CODE_MAP.put("424", "Failed Dependency (невыполненная зависимость)");
        HTTP_STATUS_CODE_MAP.put("425", "Too Early (слишком рано)");
        HTTP_STATUS_CODE_MAP.put("426", "Upgrade Required (необходимо обновление)");
        HTTP_STATUS_CODE_MAP.put("428", "Precondition Required (необходимо предусловие)");
        HTTP_STATUS_CODE_MAP.put("429", "Too Many Requests (слишком много запросов)");
        HTTP_STATUS_CODE_MAP.put("431", "Request Header Fields Too Large (поля заголовка запроса слишком большие)");
        HTTP_STATUS_CODE_MAP.put("449", "Retry With (повторить с)");
        HTTP_STATUS_CODE_MAP.put("451", "Unavailable For Legal Reasons (недоступно по юридическим причинам)");
        HTTP_STATUS_CODE_MAP.put("499", "Client Closed Request (клиент закрыл соединение)");
        HTTP_STATUS_CODE_MAP.put("500", "Internal Server Error (внутренняя ошибка сервера)");
        HTTP_STATUS_CODE_MAP.put("501", "Not Implemented (не реализовано)");
        HTTP_STATUS_CODE_MAP.put("502", "Bad Gateway (плохой, ошибочный шлюз)");
        HTTP_STATUS_CODE_MAP.put("503", "Service Unavailable (сервис недоступен)");
        HTTP_STATUS_CODE_MAP.put("504", "Gateway Timeout (шлюз не отвечает)");
        HTTP_STATUS_CODE_MAP.put("505", "HTTP Version Not Supported (версия HTTP не поддерживается)");
        HTTP_STATUS_CODE_MAP.put("506", "Variant Also Negotiates (вариант тоже проводит согласование)");
        HTTP_STATUS_CODE_MAP.put("507", "Insufficient Storage (переполнение хранилища)");
        HTTP_STATUS_CODE_MAP.put("508", "Loop Detected (обнаружено бесконечное перенаправление)");
        HTTP_STATUS_CODE_MAP.put("509", "Bandwidth Limit Exceeded");
        HTTP_STATUS_CODE_MAP.put("510", "Not Extended (не расширено)");
        HTTP_STATUS_CODE_MAP.put("511", "Network Authentication Required (требуется сетевая аутентификация)");
        HTTP_STATUS_CODE_MAP.put("520", "Unknown Error (неизвестная ошибка)");
        HTTP_STATUS_CODE_MAP.put("521", "Web Server Is Down (веб-сервер не работает)");
        HTTP_STATUS_CODE_MAP.put("522", "Connection Timed Out (соединение не отвечает)");
        HTTP_STATUS_CODE_MAP.put("523", "Origin Is Unreachable (источник недоступен)");
        HTTP_STATUS_CODE_MAP.put("524", "A Timeout Occurred (время ожидания истекло)");
        HTTP_STATUS_CODE_MAP.put("525", "SSL Handshake Failed (квитирование SSL не удалось)");
        HTTP_STATUS_CODE_MAP.put("526", "Invalid SSL Certificate (недействительный сертификат SSL)");
    }

    private Utils() {

    }

    public static Map<String, Integer> getMostCommonResources(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::address, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(MAX_AMOUNT)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static Map<String, Integer> getMostCommonStatusCode(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::codeStatus, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(MAX_AMOUNT)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static Map<String, Integer> getMostCommonUserAgents(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::httpUserAgent, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(MAX_AMOUNT)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static Map<String, Integer> getMostRemoteAddresses(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::remoteAddress, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(MAX_AMOUNT)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static int getAverageBytesResponse(List<Log> logs) {
        return logs.stream().mapToInt(Log::bytesSent).sum() / logs.size();
    }

    public static List<Path> getFilesPathsToRead(String filesPath) {
        File directory = new File(filesPath);
        ArrayList<Path> result = new ArrayList<>();
        if (directory.isDirectory()) {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                result.add(Paths.get(file.getAbsolutePath()));
            }
        } else if (directory.isFile()) {
            result.add(Path.of(filesPath));
        }
        return result;
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static void writeToFileMD(List<Path> filesList, List<Log> logs, String from, String to) {
        try {
            Path path = Paths.get("./output.md");
            Files.writeString(path, "# Общая информация\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(path, "| Метрика | Значение |\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|:-------------:|:-------------:|\n", StandardOpenOption.APPEND);
            Files.writeString(
                path,
                "| Файлы | " + Arrays.toString(filesList.toArray()) + "|\n",
                StandardOpenOption.APPEND
            );
            Files.writeString(
                path,
                "| Начальная дата | " + (from.equals("1000-01-01") ? "-" : from) + "|\n",
                StandardOpenOption.APPEND
            );
            Files.writeString(
                path,
                "| Конечная дата | " + (to.equals("3000-01-01") ? "-" : to) + "|\n",
                StandardOpenOption.APPEND
            );
            Files.writeString(path, "| Количество запросов | " + logs.size() + "|\n", StandardOpenOption.APPEND);
            Files.writeString(
                path,
                "| Средний размер ответа | " + getAverageBytesResponse(logs) + "b| \n",
                StandardOpenOption.APPEND
            );

            Files.writeString(path, "# Запрашиваемые ресурсы\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Ресурс | Количество |\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|:-------------:|:-------------:|\n", StandardOpenOption.APPEND);
            var resourceMap = getMostCommonResources(logs);
            for (var elem : resourceMap.keySet()) {
                Files.writeString(path, "|" + elem + "|" + resourceMap.get(elem) + "|\n", StandardOpenOption.APPEND);
            }

            Files.writeString(path, "# Коды ответа\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Код | Имя | Количество |\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|:-------------:|:-------------:|:-------------:|\n", StandardOpenOption.APPEND);
            var responseCodeMap = getMostCommonStatusCode(logs);
            for (var elem : responseCodeMap.keySet()) {
                Files.writeString(
                    path,
                    "|" + elem + "|" + HTTP_STATUS_CODE_MAP.get(elem) + "|" + responseCodeMap.get(elem) + "|\n",
                    StandardOpenOption.APPEND
                );
            }

            Files.writeString(path, "# Самые частые user agents\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Имя | Количество |\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|:-------------:|:-------------:|\n", StandardOpenOption.APPEND);
            var userAgentsMap = getMostCommonUserAgents(logs);
            for (var elem : userAgentsMap.keySet()) {
                Files.writeString(path, "|" + elem + "|" + userAgentsMap.get(elem) + "|\n", StandardOpenOption.APPEND);
            }

            Files.writeString(path, "# Самые частые удалённые адреса\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Адрес | Количество запросов |\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|:-------------:|:-------------:|\n", StandardOpenOption.APPEND);
            var remoteAddressesMap = getMostRemoteAddresses(logs);
            for (var elem : remoteAddressesMap.keySet()) {
                Files.writeString(
                    path,
                    "|" + elem + "|" + remoteAddressesMap.get(elem) + "|\n",
                    StandardOpenOption.APPEND
                );
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static void writeToFileADOC(List<Path> filesList, List<Log> logs, String from, String to) {
        try {
            Path path = Paths.get("./output.adoc");
            Files.writeString(path, ".Общая информация\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(path, "[cols=\"1,1\"]\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Метрика | Значение\n", StandardOpenOption.APPEND);
            Files.writeString(
                path,
                "| Файлы | " + Arrays.toString(filesList.toArray()) + System.lineSeparator(),
                StandardOpenOption.APPEND
            );
            Files.writeString(
                path,
                "| Начальная дата | " + (from.equals("1000-01-01") ? "-" : from) + System.lineSeparator(),
                StandardOpenOption.APPEND
            );
            Files.writeString(
                path,
                "| Конечная дата | " + (to.equals("3000-01-01") ? "-" : to) + System.lineSeparator(),
                StandardOpenOption.APPEND
            );
            Files.writeString(
                path,
                "| Количество запросов | " + logs.size() + System.lineSeparator(),
                StandardOpenOption.APPEND
            );
            Files.writeString(
                path,
                "| Средний размер ответа | " + getAverageBytesResponse(logs) + "b" + System.lineSeparator(),
                StandardOpenOption.APPEND
            );
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);

            Files.writeString(path, ".Запрашиваемые ресурсы\n", StandardOpenOption.APPEND);
            Files.writeString(path, "[cols=\"1,1\"]\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Ресурс | Количество\n", StandardOpenOption.APPEND);
            var resourceMap = getMostCommonResources(logs);
            for (var elem : resourceMap.keySet()) {
                Files.writeString(
                    path,
                    "|" + elem + "|" + resourceMap.get(elem) + System.lineSeparator(),
                    StandardOpenOption.APPEND
                );
            }
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);

            Files.writeString(path, ".Коды ответа" + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(path, "[cols=\"1,1,1\"]\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Код | Имя | Количество" + System.lineSeparator(), StandardOpenOption.APPEND);
            var responseCodeMap = getMostCommonStatusCode(logs);
            for (var elem : responseCodeMap.keySet()) {
                Files.writeString(
                    path,
                    "|" + elem + "|" + HTTP_STATUS_CODE_MAP.get(elem) + "|" + responseCodeMap.get(elem)
                        + System.lineSeparator(),
                    StandardOpenOption.APPEND
                );
            }
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);

            Files.writeString(path, ".Самые частые user agents\n", StandardOpenOption.APPEND);
            Files.writeString(path, "[cols=\"1,1\"]\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Имя | Количество\n", StandardOpenOption.APPEND);
            var userAgentsMap = getMostCommonUserAgents(logs);
            for (var elem : userAgentsMap.keySet()) {
                Files.writeString(
                    path,
                    "|" + elem + "|" + userAgentsMap.get(elem) + System.lineSeparator(),
                    StandardOpenOption.APPEND
                );
            }
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);

            Files.writeString(path, ".Самые частые удалённые адреса\n", StandardOpenOption.APPEND);
            Files.writeString(path, "[cols=\"1,1\"]\n", StandardOpenOption.APPEND);
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);
            Files.writeString(path, "| Адрес | Количество запросов\n", StandardOpenOption.APPEND);
            var remoteAddressesMap = getMostRemoteAddresses(logs);
            for (var elem : remoteAddressesMap.keySet()) {
                Files.writeString(
                    path,
                    "|" + elem + "|" + remoteAddressesMap.get(elem) + System.lineSeparator(),
                    StandardOpenOption.APPEND
                );
            }
            Files.writeString(path, "|===\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
