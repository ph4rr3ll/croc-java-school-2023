package ru.croc.java.lesson4.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.java.lesson4.user.User;
import ru.croc.java.lesson4.user.UserCache;

/**
 * Проверки {link Cache}.
 */
public class CacheTest {

    /**
     * Проверка добавления/извлечения пользователя в/из кэш(а).
     */
    @Test
    public void test() {
        final Cache<User> cache = new Cache<>();
        final String alexLogin = "alex";
        final User alex = new User(alexLogin, "Александр");

        cache.put(alex);
        final User actual = cache.get(alexLogin);
        Assertions.assertEquals(alex, actual);
    }
    /**
     * Проверка добавления/извлечения пользователя в/из кэш(а)
     * для друго типа.
     */
    @Test
    public void testForGetKey() {
        final Cache<GetKey> cache = new Cache<>();
        final String key = "KEY-1";
        final GetKey value = () -> key;


        cache.put(value);
        final GetKey actual = cache.get(key);
        Assertions.assertEquals(value, actual);
    }
}
