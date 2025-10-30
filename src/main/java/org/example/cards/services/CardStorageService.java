package org.example.cards.services;

import jakarta.inject.Singleton;
import org.example.cards.PaymentCard;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class CardStorageService {
    static List<PaymentCard> allCards = new ArrayList<PaymentCard>();

    public List<PaymentCard> getAllCards() {
        return allCards;
    }

    public PaymentCard getCardByCardNumber(String cardNumber) {
        for (PaymentCard card : allCards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        throw new IllegalArgumentException();
    }
}
