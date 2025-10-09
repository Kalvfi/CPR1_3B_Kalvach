package org.example.accounts.services;

import org.example.accounts.BankAccount;
import org.example.accounts.cards.CardFactory;
import org.example.accounts.cards.CardStorageService;
import org.example.accounts.cards.PaymentCard;

import java.util.List;

public class AccountCardsService {

    CardFactory cf = new CardFactory();

    public void addCard(BankAccount bankAccount)
    {
        List<PaymentCard> cards = bankAccount.getCards();
        PaymentCard card = cf.createPaymentCard(bankAccount.getCustomer().getFullName(),bankAccount);
        CardStorageService.getAllCards().add(card);
        cards.add(card);
    }

    public void removeCard(BankAccount bankAccount, String cardNumber)
    {
        List<PaymentCard> cards = bankAccount.getCards();
        cards.forEach((card)->{
            if (card.getCardNumber().equals(cardNumber))
            {
                CardStorageService.getAllCards().remove(card);
                bankAccount.getCards().remove(card);}
        });
    }
}
