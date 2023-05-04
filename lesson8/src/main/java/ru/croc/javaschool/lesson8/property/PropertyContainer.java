package ru.croc.javaschool.lesson8.property;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyContainer {

    private static Map<String, String> properties = new HashMap<>();

    public static void loadProperties() throws IOException {
        var appProperties = new Properties();
        try {
            appProperties.load(
                    Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
            for (var entry : appProperties.entrySet()) {
                properties.put((String) entry.getKey(), (String) entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Возникла ошибка при загрузке настроек");
            throw e;
        }
    }

    public static String getProperty(String propertyKey) {
        return properties.getOrDefault(propertyKey, "");
    }
}
