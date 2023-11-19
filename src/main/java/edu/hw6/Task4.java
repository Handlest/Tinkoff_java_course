package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int ERROR_CODE = -1;

    private Task4() {

    }

    public static long checkOutputStringComposition() {
        try {
            Path path = Files.createTempFile("output", ".txt");
            OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE);

            CRC32 crc32 = new CRC32();
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, crc32);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);

            PrintWriter printWriter = new PrintWriter(outputStreamWriter);

            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");

            printWriter.close();
            outputStreamWriter.close();
            bufferedOutputStream.close();
            checkedOutputStream.close();
            outputStream.close();

            return crc32.getValue();

        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return ERROR_CODE;
    }
}
