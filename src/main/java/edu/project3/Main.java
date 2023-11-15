package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.project3.Utils.getFilesPathsToRead;
import static edu.project3.Utils.writeToFileADOC;
import static edu.project3.Utils.writeToFileMD;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String DATE_FORMAT = "dd-MM-yyyy";
    private final static String ADOC = "adoc";
    private final static String MARKDOWN = "markdown";

    private Main() {

    }

    @SuppressWarnings({"MissingSwitchDefault", "InnerAssignment"})
    public static void main(String[] args) {
        List<Log> logsList = new ArrayList<>();
        String stringPath = null;
        LocalDate from = LocalDate.parse("01-01-1000", DateTimeFormatter.ofPattern(DATE_FORMAT));
        LocalDate to = LocalDate.parse("01-01-3000", DateTimeFormatter.ofPattern(DATE_FORMAT));
        String format = MARKDOWN;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--path" -> stringPath = args[i + 1];
                case "--from" -> from = LocalDate.parse(args[i + 1], DateTimeFormatter.ofPattern(DATE_FORMAT));
                case "--to" -> to = LocalDate.parse(args[i + 1], DateTimeFormatter.ofPattern(DATE_FORMAT));
                case "--format" -> format = args[i + 1];
            }
        }
        if (stringPath == null) {
            throw new RuntimeException("Variable 'path' was not specified");
        }

        ArrayList<Path> filePaths = new ArrayList<>(getFilesPathsToRead(stringPath));

        for (Path filePath : filePaths) {
            try (Stream<String> stream = Files.lines(filePath)) {
                LocalDate finalTo = to;
                LocalDate finalFrom = from;
                stream.forEach(e -> {
                    Log log = Log.createLog(e);
                    if (log.time().isAfter(finalFrom) && log.time().isBefore(finalTo)) {
                        logsList.add(log);
                    }
                });
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }

        if (format.equals(ADOC)) {
            writeToFileADOC(filePaths, logsList, from.toString(), to.toString());
        } else if (format.equals(MARKDOWN)) {
            writeToFileMD(filePaths, logsList, from.toString(), to.toString());
        } else {
            LOGGER.info("Invalid output format. Try using markdown or adoc");
        }
    }
}
