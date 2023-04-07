package ru.croc.java.lesson4.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Проверяет {@link UserCache}.
 */
public class UserCacheTest {

    /**
     * Проверка добавления/извлечения пользователя в/из кэш(а).
     */
    @Test
    public void test() {
        final UserCache cache = new UserCache();
        final String alexLogin = "alex";
        final User alex = new User(alexLogin, "Александр");

        cache.put(alex);
        final User actual = cache.get(alexLogin);
        Assertions.assertEquals(alex, actual);
    }
}
