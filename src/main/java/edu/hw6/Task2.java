package edu.hw6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    private Task2() {

    }

    public static void cloneFile(Path path) throws IOException {
        Path oldPath = Path.of(path.toString());
        Path currentPath = oldPath;

        if (!Files.exists(currentPath)){
            throw new FileNotFoundException("Такого файла не существует");
        }

        for (int i = 1;; i++) {
            if(Files.exists(currentPath)){
                oldPath = currentPath;
                String[] currentPathSplitted = path.toString().split("\\.");
                currentPath = Path.of(currentPathSplitted[0] + (i == 1 ? " — копия.": " — копия "+"("+i+")"+".")
                    + currentPathSplitted[1]);
            }
            else{
                Files.copy(oldPath, currentPath);
                break;
            }
        }
    }
}
