package org.example.cards.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Logger;
import org.example.accounts.services.AccountTransferService;
import org.example.cards.PaymentCard;

import java.util.Scanner;

@Singleton
public class ATM {

    @Inject
    private AccountTransferService accountTransferService;

    @Inject
    private Logger logger;

    @Inject
    Scanner scanner;

    public void withdraw(PaymentCard card, double amount){

        System.out.println("Enter card PIN: ");
        String input = scanner.nextLine();

        if(!input.equals(card.getPin())){
            throw new IllegalArgumentException("Wrong pin");
        }

        accountTransferService.withdraw(card.getBankAccount(), amount);
    }

    public void payOnline(PaymentCard card, double amount){

        System.out.println("Enter card number: ");
        String cardNumber = scanner.nextLine();

        System.out.println("Enter card expire month: ");
        String expireMonth = scanner.nextLine();

        System.out.println("Enter card expire year: ");
        String expireYear = scanner.nextLine();

        System.out.println("Enter card cvc: ");
        String cvc = scanner.nextLine();

        if(!cardNumber.equals(card.getCardNumber()) || !expireMonth.equals(card.getExpireMonth()) || !expireYear.equals(card.getExpireYear()) || !cvc.equals(card.getCvc())){
            throw new IllegalArgumentException("Wrong card information");
        }

        accountTransferService.withdraw(card.getBankAccount(), amount);
    }
}
