package ru.croc.javaschool.lesson5.exception;

public class InvalidCardException extends RuntimeException {

    public InvalidCardException() {
        super("Карта не действительна");
    }
}
