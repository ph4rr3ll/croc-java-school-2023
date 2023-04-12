package ru.croc.javaschool.lesson5;

import ru.croc.javaschool.lesson5.exception.NotEnoughMoneyException;
import ru.croc.javaschool.lesson5.model.Card;
import ru.croc.javaschool.lesson5.processing.HiTechProcessingTerminal;
import ru.croc.javaschool.lesson5.processing.LegacyProcessingTerminal;

import java.math.BigDecimal;

public class Demo {

    public static void main(String[] args) throws NotEnoughMoneyException {
        var legacyProcessingTerminal = new LegacyProcessingTerminal();

        var sourceCard = new Card(
                "1234",
                "01/25",
                "213",
                "User 1");
        sourceCard.increaseBalance(BigDecimal.valueOf(1000.00));

        legacyProcessingTerminal.takeOff(sourceCard, BigDecimal.valueOf(100.00));
        try {
            legacyProcessingTerminal.takeOff(sourceCard, BigDecimal.valueOf(1000.00));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        var destinationCard = new Card(
                "5678",
                "03/26",
                "356",
                "User 2");
        destinationCard.increaseBalance(BigDecimal.valueOf(1000));

        var hiTechProcessingTerminal = new HiTechProcessingTerminal();

        try {
            hiTechProcessingTerminal.transfer(
                    sourceCard,
                    destinationCard,
                    BigDecimal.valueOf(400.00));
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        hiTechProcessingTerminal.transfer(
                sourceCard,
                destinationCard,
                BigDecimal.valueOf(400.00));
    }
}
