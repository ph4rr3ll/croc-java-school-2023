package ru.croc.javaschool.lesson5.processing;

import ru.croc.javaschool.lesson5.model.Card;

import java.math.BigDecimal;

public interface ProcessingTerminal {

    void transfer(Card source, Card destination, BigDecimal sum) throws Exception;

    void takeOff(Card source, BigDecimal sum);

    void topUp(Card destination, BigDecimal sum);
}
