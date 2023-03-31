package ru.croc.java.lesson4.user;

import ru.croc.java.lesson4.cache.GetKey;

/**
 * Пользователь.
 */
public class User implements GetKey {
    /** Имя пользователя. */
    private final String login;
    /** ФИО. */
    private final String name;

    /**
     * Конструктор {@link User}.
     *
     * @param login имя пользователя
     * @param name ФИО
     */
    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String key() {
        return getLogin();
    }
}
