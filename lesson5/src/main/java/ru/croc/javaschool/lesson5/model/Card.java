package ru.croc.javaschool.lesson5.model;

import ru.croc.javaschool.lesson5.exception.NotEnoughMoneyException;

import java.math.BigDecimal;

public class Card {

    public Card(String number, String expirationDate, String cvcCode, String cardHolderName) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvcCode = cvcCode;
        this.cardHolderName = cardHolderName;
        this.balance = BigDecimal.ZERO;
    }

    private String number;

    private String expirationDate;

    private String cvcCode;

    private String cardHolderName;

    private BigDecimal balance;

    public String getNumber() {
        return number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void increaseBalance(BigDecimal sum) {
        this.balance = this.balance.add(sum);
    }

    public void decreaseBalance(BigDecimal sum) throws NotEnoughMoneyException {
        if (this.balance.compareTo(sum) < 0) {
            throw new NotEnoughMoneyException();
        }

        this.balance = this.balance.subtract(sum);
    }
}
