package ru.croc.java.lesson4.cache;

import java.util.HashMap;
import java.util.Map;

public class Cache<T extends GetKey> {
    private Map<String, T> cache = new HashMap<>();

    public void put(T value) {
        cache.put(value.key(), value);
    }

    public T get(String key) {
        return cache.getOrDefault(key, null);
    }
}
