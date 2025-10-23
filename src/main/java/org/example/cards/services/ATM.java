package org.example.cards.services;

import org.example.Logger;
import org.example.accounts.services.AccountBalanceService;
import org.example.cards.PaymentCard;

import java.util.Scanner;

public class ATM {

    AccountBalanceService accountBalanceService;
    Logger logger;

    public ATM(AccountBalanceService accountBalanceService, Logger logger) {
        this.accountBalanceService = accountBalanceService;
        this.logger = logger;
    }

    public void withdraw(PaymentCard card, double amount){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card PIN: ");
        String input = scanner.nextLine();

        if(!input.equals(card.getPin())){
            throw new IllegalArgumentException("Wrong pin");
        }

        accountBalanceService.withdraw(card.getBankAccount(), amount);
        logger.logWithdrawal(amount, card);
    }

    public void payOnline(PaymentCard card, double amount){
        Scanner scanner = new Scanner(System.in);
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

        accountBalanceService.withdraw(card.getBankAccount(), amount);
        logger.logPayment(amount, card);
    }
}
