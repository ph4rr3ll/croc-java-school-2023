package ru.croc.java.lesson4.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Кэш пользователей.
 */
public class UserCache {
    private Map<String, User> cache = new HashMap<>();

    /**
     * Добавляет пользователя в кэш.
     *
     * @param user пользователь
     */
    public void put(User user) {
        cache.put(user.getLogin(), user);
    }

    /**
     * Возвращает пользователя из кэша.
     *
     * @param login логин
     * @return существующий пользователь или null
     */
    public User get(String login) {
        return cache.getOrDefault(login, null);
    }
}
