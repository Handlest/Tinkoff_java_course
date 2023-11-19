package edu.hw6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import java.io.*;
import java.util.*;

public class DiskMap implements Map<String, String> {
    private final File file;
    private final static Logger LOGGER = LogManager.getLogger();

    public DiskMap(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public int size() {
        return readMap().size();
    }

    @Override
    public boolean isEmpty() {
        return readMap().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return readMap().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return readMap().containsValue(value);
    }

    @Override
    public String get(Object key) {
        return readMap().get(key);
    }

    @Override
    public String put(String key, String value) {
        Map<String, String> map = readMap();
        String previousValue = map.put(key, value);
        saveMap(map);
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        Map<String, String> map = readMap();
        String removedValue = map.remove(key);
        saveMap(map);
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        Map<String, String> map = readMap();
        map.putAll(m);
        saveMap(map);
    }

    @Override
    public void clear() {
        saveMap(new HashMap<>());
    }

    @Override
    public @NotNull Set<String> keySet() {
        return readMap().keySet();
    }

    @Override
    public @NotNull Collection<String> values() {
        return readMap().values();
    }

    @Override
    public @NotNull Set<Entry<String, String>> entrySet() {
        return readMap().entrySet();
    }

    private Map<String, String> readMap() {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return map;
    }

    private void saveMap(Map<String, String> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (var entry : map.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
