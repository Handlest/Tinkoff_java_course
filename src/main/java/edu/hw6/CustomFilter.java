package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.Set;

public interface CustomFilter extends DirectoryStream.Filter<Path> {
    boolean accept(Path entry) throws IOException;

    default CustomFilter and(CustomFilter other) {
        return entry -> this.accept(entry) && other.accept(entry);
    }

    static CustomFilter regularFile() {
        return Files::isRegularFile;
    }

    static CustomFilter readable() {
        return Files::isReadable;
    }

    static CustomFilter byAttributes(Set<PosixFilePermission> permissions, boolean isReadable, boolean isWritable, boolean isExecutable) {
        return entry -> {
            Set<PosixFilePermission> filePermissions = Files.getPosixFilePermissions(entry);
            boolean hasPermissions = filePermissions.containsAll(permissions);
            boolean hasReadable = Files.isReadable(entry) == isReadable;
            boolean hasWritable = Files.isWritable(entry) == isWritable;
            boolean hasExecutable = Files.isExecutable(entry) == isExecutable;
            return hasPermissions && hasReadable && hasWritable && hasExecutable;
        };
    }

    static CustomFilter bySize(long minSize, long maxSize) {
        return entry -> {
            long fileSize = Files.size(entry);
            return fileSize >= minSize && fileSize <= maxSize;
        };
    }

    static CustomFilter byExtension(String extension) {
        return entry -> {
            String entryFileName = entry.getFileName().toString();
            String entryExtension = entryFileName.substring(entryFileName.lastIndexOf(".") + 1);
            return entryExtension.equals(extension);
        };
    }

    static CustomFilter byNamePattern(String pattern) {
        return entry -> {
            String fileName = entry.getFileName().toString();
            return fileName.matches(pattern);
        };
    }

    static CustomFilter byMagicBytes(byte[] magicBytes) {
        return entry -> {
            byte[] fileBytes = Files.readAllBytes(entry);
            return Arrays.equals(Arrays.copyOfRange(fileBytes, 0, magicBytes.length), magicBytes);
        };
    }
}
