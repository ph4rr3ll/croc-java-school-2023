package ru.croc.javaschool.lesson5.exception;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException() {
        super("Недостаточно средств на счету");
    }
}
