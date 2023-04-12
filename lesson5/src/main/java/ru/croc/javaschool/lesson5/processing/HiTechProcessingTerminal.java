package ru.croc.javaschool.lesson5.processing;

import ru.croc.javaschool.lesson5.exception.InvalidCardException;
import ru.croc.javaschool.lesson5.exception.NotEnoughMoneyException;
import ru.croc.javaschool.lesson5.model.Card;

import java.math.BigDecimal;
import java.util.Objects;

public class HiTechProcessingTerminal implements ProcessingTerminal {

    @Override
    public void transfer(Card source, Card destination, BigDecimal sum)
            throws NotEnoughMoneyException {
        if (source.getBalance().compareTo(sum) >= 0) {
            System.out.printf("Выполняется перевод на сумму: %s у.е.%n", sum);
            source.decreaseBalance(sum);
            destination.increaseBalance(sum);
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    @Override
    public void takeOff(Card source, BigDecimal sum) {
        if (Objects.isNull(source)) {
            throw new InvalidCardException();
        }

        try {
            source.decreaseBalance(sum);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void topUp(Card destination, BigDecimal sum) {
        if (Objects.isNull(destination)) {
            throw new InvalidCardException();
        }

        System.out.printf("Выполняется зачисление наличных на сумму: %s у.е.%n", sum);
        destination.increaseBalance(sum);
    }
}
