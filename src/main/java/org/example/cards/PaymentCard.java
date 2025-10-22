package org.example.cards;

import org.example.accounts.BankAccount;

public class PaymentCard {

    private String cardNumber;

    private String cvc;

    private String expireMonth;
    private String expireYear;

    private String owner;

    private String pin;

    private BankAccount bankAccount;

    public PaymentCard(String owner, String expireYear, String expireMonth, String cvc, String cardNumber, String pin, BankAccount bankAccount) {
        this.owner = owner;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
        this.cvc = cvc;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public String getOwner() {
        return owner;
    }

    public String getPin() {return pin;}

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
