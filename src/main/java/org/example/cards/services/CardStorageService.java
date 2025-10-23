package org.example.cards.services;

import org.example.cards.PaymentCard;

import java.util.ArrayList;
import java.util.List;

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
