package ru.croc.javaschool.lesson5.processing;

import ru.croc.javaschool.lesson5.exception.NotEnoughMoneyException;
import ru.croc.javaschool.lesson5.model.Card;

import java.math.BigDecimal;
import java.util.Objects;

public class LegacyProcessingTerminal implements ProcessingTerminal {

    public void transfer(Card source, Card destination, BigDecimal sum)
            throws Exception  {
        if (source.getBalance().compareTo(sum) >= 0) {
            System.out.printf("Выполняется перевод на сумму: %s у.е.%n", sum);
            source.decreaseBalance(sum);
            destination.increaseBalance(sum);
        } else {
            throw new Exception("Недостаточно средств на балансе");
        }
    }

    public void takeOff(Card source, BigDecimal sum) {
        try {
            source.decreaseBalance(sum);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void topUp(Card destination, BigDecimal sum) {
        System.out.printf("Выполняется зачисление наличных на сумму: %s у.е.%n", sum);
        destination.increaseBalance(sum);
    }
}
