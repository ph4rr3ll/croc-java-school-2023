package ru.croc.java.lesson4;

import ru.croc.java.lesson4.user.User;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user = new User("", "") {
            @Override
            public String getLogin() {
                return super.getLogin();
            }
        };

        Function<String, String> f = new Function<>() {
            @Override
            public String apply(String s) {
                return s + s;
            }
        };
        f.apply("222");

        f = s -> s + s;
    }
}