package org.example;

import jakarta.inject.Singleton;
import org.example.accounts.BaseBankAccount;
import org.example.cards.PaymentCard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Singleton
public class Logger {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String timestamp() {
        return "[" + LocalDateTime.now().format(formatter) + "]";
    }

    public void logWithdrawal(double amount, BaseBankAccount account) {
        System.out.println(timestamp() + "Withdrawn " + amount + " from account " + account.getUuid());
    }
    public void logWithdrawal(double amount, PaymentCard card){
        System.out.println(timestamp() + "Withdrawn " + amount + " using card " + card.getCardNumber() + " from account " + card.getBankAccount().getUuid());
    }
    public void logDeposit(double amount, BaseBankAccount account) {
        System.out.println(timestamp() + "Deposited " + amount + " to account " + account.getUuid());
    }
    public void logPayment(double amount, PaymentCard card) {
        System.out.println(timestamp() + "Paid " + amount + " using card " + card.getCardNumber() + " from account " + card.getBankAccount().getUuid());
    }
}
