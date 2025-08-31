package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private final Properties props = new Properties();
    private static boolean instanceCreated = false;
    
    private AppSettings() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance() method to get the single instance");
        }
        instanceCreated = true;
    }

    public static AppSettings getInstance() {
        return Helper.INSTANCE;
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    private Object readResolve() {
        return getInstance();
    }

    private static class Helper{
        private static final AppSettings INSTANCE = new AppSettings();

    }
}
